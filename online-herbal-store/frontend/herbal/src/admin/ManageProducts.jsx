// import React, { useState, useEffect } from "react";
// import axios from "axios";

// const ManageProducts = () => {
//   const [products, setProducts] = useState([]);
//   const [newProduct, setNewProduct] = useState({
//     name: "",
//     description: "",
//     price: "",
//     image_url: "",
//   });

//   useEffect(() => {
//     fetchProducts();
//   }, []);

//   const fetchProducts = async () => {
//     const res = await axios.get("http://127.0.0.1:8000/products/");
//     setProducts(res.data);
//   };

//   const handleAdd = async () => {
//     await axios.post("http://127.0.0.1:8000/products/", newProduct);
//     fetchProducts();
//     setNewProduct({ name: "", description: "", price: "", image_url: "" });
//   };

//   const handleDelete = async (id) => {
//     await axios.delete(`http://127.0.0.1:8000/products/${id}`);
//     fetchProducts();
//   };

//   return (
//     <div style={{ padding: "30px" }}>
//       <h2>Manage Products</h2>

//       <div style={{ marginBottom: "20px" }}>
//         <input
//           placeholder="Name"
//           value={newProduct.name}
//           onChange={(e) =>
//             setNewProduct({ ...newProduct, name: e.target.value })
//           }
//         />
//         <input
//           placeholder="Description"
//           value={newProduct.description}
//           onChange={(e) =>
//             setNewProduct({ ...newProduct, description: e.target.value })
//           }
//         />
//         <input
//           placeholder="Price"
//           type="number"
//           value={newProduct.price}
//           onChange={(e) =>
//             setNewProduct({ ...newProduct, price: e.target.value })
//           }
//         />
//         <input
//           placeholder="Image filename"
//           value={newProduct.image_url}
//           onChange={(e) =>
//             setNewProduct({ ...newProduct, image_url: e.target.value })
//           }
//         />
//         <button onClick={handleAdd}>Add Product</button>
//       </div>

//       <ul>
//         {products.map((p) => (
//           <li key={p.id}>
//             {p.name} - ₹{p.price}
//             <button onClick={() => handleDelete(p.id)}>Delete</button>
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// };

// export default ManageProducts;


import { useEffect, useState } from "react";

function ManageProducts() {
  const [products, setProducts] = useState([]);
  const [form, setForm] = useState({ name: "", description: "", price: "", image_url: "" });
  const [editingId, setEditingId] = useState(null);

  // Fetch products
  const loadProducts = () => {
    fetch("http://localhost:8000/products/")
      .then(res => res.json())
      .then(data => setProducts(data));
  };

  useEffect(() => {
    loadProducts();
  }, []);

  // Handle input change
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // Create or Update product
  const handleSubmit = async (e) => {
    e.preventDefault();
    const url = editingId
      ? `http://localhost:8000/products/${editingId}`
      : "http://localhost:8000/products/";

    const method = editingId ? "PUT" : "POST";

    await fetch(url, {
      method,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form)
    });

    setForm({ name: "", description: "", price: "", image_url: "" });
    setEditingId(null);
    loadProducts();
  };

  // Delete product
  const handleDelete = async (id) => {
    await fetch(`http://localhost:8000/products/${id}`, { method: "DELETE" });
    loadProducts();
  };

  // Edit mode
  const handleEdit = (product) => {
    setForm(product);
    setEditingId(product.id);
  };

  return (
    <div style={{ padding: "25px" }}>
      <h2>Manage Products</h2>

      {/* Add / Edit Form */}
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" placeholder="Product Name" value={form.name} onChange={handleChange} required /> <br />
        <input type="text" name="description" placeholder="Description" value={form.description} onChange={handleChange} required /> <br />
        <input type="number" name="price" placeholder="Price" value={form.price} onChange={handleChange} required /> <br />

        {/* Image filename only: example aloe.jpg */}
        <input type="text" name="image_url" placeholder="Image Filename" value={form.image_url} onChange={handleChange} required /> <br />

        <button type="submit">{editingId ? "Update Product" : "Add Product"}</button>
      </form>

      <hr />

      {/* Product Table */}
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th><th>Name</th><th>Price</th><th>Image</th><th>Edit</th><th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {products.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.name}</td>
              <td>₹{p.price}</td>
              <td><img src={p.image_url} width="75" /></td>

              <td><button onClick={() => handleEdit(p)}>Edit</button></td>
              <td><button onClick={() => handleDelete(p.id)}>Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>

    </div>
  );
}

export default ManageProducts;
