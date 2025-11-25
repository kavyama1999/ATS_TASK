
// import React, { useEffect, useState } from "react";
// import axios from "axios";
// import { FiEdit, FiTrash2 } from "react-icons/fi";
// import "./ManageProducts.css";
// import { Link } from "react-router-dom";   // ✅ Add this import


// const ManageProducts = () => {
//   const [products, setProducts] = useState([]);
//   const [editingProduct, setEditingProduct] = useState(null);
//   const [formData, setFormData] = useState({
//     name: "",
//     price: "",
//     description: "",
//     image: null,
//     image_url: "",
//   });

//   useEffect(() => {
//     axios
//       .get("http://127.0.0.1:8000/products/")
//       .then((res) => setProducts(res.data))
//       .catch((err) => console.error(err));
//   }, []);

//   const handleDelete = async (id) => {
//     if (window.confirm("Are you sure you want to delete this product?")) {
//       await axios.delete(`http://127.0.0.1:8000/products/${id}`);
//       setProducts(products.filter((p) => p.id !== id));
//     }
//   };

//   const handleEdit = (product) => {
//     setEditingProduct(product);
//     setFormData({
//       name: product.name,
//       price: product.price,
//       description: product.description,
//       image: null,
//       image_url: product.image_url.split("/").pop() || "",
//     });
//   };

//   const handleChange = (e) => {
//     const { name, value, files } = e.target;
//     if (name === "image" && files.length > 0) {
//       setFormData((prev) => ({ ...prev, image: files[0] }));
//     } else {
//       setFormData((prev) => ({ ...prev, [name]: value }));
//     }
//   };

//   const handleSave = async () => {
//     try {
//       const form = new FormData();
//       form.append("name", formData.name);
//       form.append("price", formData.price);
//       form.append("description", formData.description);

//       if (formData.image) {
//         form.append("image", formData.image);
//       } else {
//         form.append("image_url", formData.image_url);
//       }

//       const res = await axios.put(
//         `http://127.0.0.1:8000/products/${editingProduct.id}`,
//         form,
//         { headers: { "Content-Type": "multipart/form-data" } }
//       );

//       setProducts(
//         products.map((p) =>
//           p.id === editingProduct.id ? res.data : p
//         )
//       );

//       setEditingProduct(null);
//     } catch (err) {
//       console.error(err);
//       alert("Error updating product!");
//     }
//   };

//   return (
//     <div className="manage-products-container">
//       <h2 className="page-title">🛍 Manage Products</h2>

//       <div className="top-actions">
//         <Link to="/admindashboard/admin-view-products" className="top-btn view-btn">
//           View Products
//         </Link>

//         <Link to="/admindashboard/add-product" className="top-btn add-btn">
//           Add Product
//         </Link>
//       </div>


//       <div className="product-grid">
//         {products.map((product) => (
//           <div key={product.id} className="product-card">
//             <img
//               src={product.image_url}
//               alt={product.name}
//               className="product-image"
//             />
//             <div className="product-info">
//               <h3>{product.name}</h3>
//               <p className="desc">{product.description}</p>
//               <p className="price">₹{product.price}</p>

//               {/* <div className="action-buttons">
//                 <button className="edit-btn">
//                   <FiEdit />
//                 </button> */}


//               <div className="action-buttons">
//                 {/* ✔ FIXED: Edit button calls handleEdit */}
//                 <button
//                   className="edit-btn"
//                   onClick={() => handleEdit(product)}
//                 >
//                   <FiEdit />
//                 </button>

//                 {/* 🔴 DELETE BUTTON WITH RED ICON */}
//                 <button
//                   className="delete-btn"
//                   onClick={() => handleDelete(product.id)}
//                 >
//                   <FiTrash2 className="trash-icon" />
//                 </button>
//               </div>
//             </div>
//           </div>
//         ))}
//       </div>

//       {editingProduct && (
//         <div className="modal-overlay">
//           <div className="modal">
//             <h3>Edit Product</h3>

//             <input
//               type="text"
//               name="name"
//               placeholder="Name"
//               value={formData.name}
//               onChange={handleChange}
//             />

//             <input
//               type="number"
//               name="price"
//               placeholder="Price"
//               value={formData.price}
//               onChange={handleChange}
//             />

//             <input
//               type="text"
//               name="description"
//               placeholder="Description"
//               value={formData.description}
//               onChange={handleChange}
//             />

//             <input
//               type="file"
//               name="image"
//               accept="image/*"
//               onChange={handleChange}
//             />

//             {formData.image_url && !formData.image && (
//               <img
//                 src={`http://127.0.0.1:8000/images/${formData.image_url}`}
//                 alt="Current"
//                 style={{ width: "100px", marginTop: "10px" }}
//               />
//             )}

//             <div className="modal-actions">
//               <button className="save-btn" onClick={handleSave}>
//                 Save
//               </button>
//               <button
//                 className="cancel-btn"
//                 onClick={() => setEditingProduct(null)}
//               >
//                 Cancel
//               </button>
//             </div>
//           </div>
//         </div>
//       )}
//     </div>
//   );
// };

// export default ManageProducts;





import React, { useEffect, useState } from "react";
import { FiEdit, FiTrash2 } from "react-icons/fi";
import "./ManageProducts.css";
import { Link } from "react-router-dom";
import api from "../api/axios";     // ✅ IMPORTANT

const ManageProducts = () => {
  const [products, setProducts] = useState([]);
  const [editingProduct, setEditingProduct] = useState(null);

  const [formData, setFormData] = useState({
    name: "",
    price: "",
    description: "",
    image: null,
    image_url: "",
  });

  // ✅ Load products
  useEffect(() => {
    api
      .get("/products")
      .then((res) => setProducts(res.data))
      .catch((err) => console.error("Products error:", err));
  }, []);

  // ❌ DON'T USE axios.delete
  // ✅ USE api.delete
  const handleDelete = async (id) => {
    if (window.confirm("Delete this product?")) {
      await api.delete(`/products/${id}`);
      setProducts(products.filter((p) => p.id !== id));
    }
  };

  const handleEdit = (product) => {
    setEditingProduct(product);
    setFormData({
      name: product.name,
      price: product.price,
      description: product.description,
      image: null,
      image_url: product.image_url.split("/").pop(),
    });
  };

  const handleChange = (e) => {
    const { name, value, files } = e.target;

    if (name === "image" && files.length > 0) {
      setFormData((prev) => ({ ...prev, image: files[0] }));
    } else {
      setFormData((prev) => ({ ...prev, [name]: value }));
    }
  };

  const handleSave = async () => {
    try {
      const form = new FormData();
      form.append("name", formData.name);
      form.append("price", formData.price);
      form.append("description", formData.description);

      if (formData.image) {
        form.append("image", formData.image);
      } else {
        form.append("image_url", formData.image_url);
      }

      const res = await api.put(
        `/products/${editingProduct.id}`,
        form,
        { headers: { "Content-Type": "multipart/form-data" } }
      );

      setProducts(
        products.map((p) =>
          p.id === editingProduct.id ? res.data : p
        )
      );

      setEditingProduct(null);
    } catch (err) {
      console.error("Update error:", err);
      alert("Error updating product!");
    }
  };

  return (
    <div className="manage-products-container">
      <h2 className="page-title">🛍 Manage Products</h2>

      <div className="top-actions">
        <Link to="/admindashboard/admin-view-products" className="top-btn view-btn">
          View Products
        </Link>

        <Link to="/admindashboard/add-product" className="top-btn add-btn">
          Add Product
        </Link>
      </div>

      <div className="product-grid">
        {products.map((product) => (
          <div key={product.id} className="product-card">
            <img
              src={product.image_url}
              alt={product.name}
              className="product-image"
            />

            <div className="product-info">
              <h3>{product.name}</h3>
              <p className="desc">{product.description}</p>
              <p className="price">₹{product.price}</p>

              <div className="action-buttons">
                <button className="edit-btn" onClick={() => handleEdit(product)}>
                  <FiEdit />
                </button>

                <button className="delete-btn" onClick={() => handleDelete(product.id)}>
                  <FiTrash2 className="trash-icon" />
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>

      {editingProduct && (
        <div className="modal-overlay">
          <div className="modal">
            <h3>Edit Product</h3>

            <input type="text" name="name" value={formData.name} onChange={handleChange} />
            <input type="number" name="price" value={formData.price} onChange={handleChange} />
            <input type="text" name="description" value={formData.description} onChange={handleChange} />

            <input type="file" name="image" accept="image/*" onChange={handleChange} />

            {formData.image_url && !formData.image && (
              <img
                src={`http://192.168.0.113:8000/images/${formData.image_url}`}
                alt="Current"
                style={{ width: "100px", marginTop: "10px" }}
              />
            )}

            <div className="modal-actions">
              <button className="save-btn" onClick={handleSave}>Save</button>
              <button className="cancel-btn" onClick={() => setEditingProduct(null)}>Cancel</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default ManageProducts;







