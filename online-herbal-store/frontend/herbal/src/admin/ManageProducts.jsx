// import React, { useEffect, useState } from "react";
// import axios from "axios";
// import { FiEdit, FiTrash2 } from "react-icons/fi";
// import "./ManageProducts.css";

// const ManageProducts = () => {
//   const [products, setProducts] = useState([]);
//   const [editingProduct, setEditingProduct] = useState(null);
//   const [formData, setFormData] = useState({
//     name: "",
//     price: "",
//     description: "",
//     image: null,      // selected file
//     image_url: "",    // existing image filename
//   });

//   // Fetch products
//   useEffect(() => {
//     axios.get("http://127.0.0.1:8000/products/")
//       .then(res => setProducts(res.data))
//       .catch(err => console.error(err));
//   }, []);

//   // Delete product
//   const handleDelete = async (id) => {
//     if (window.confirm("Are you sure you want to delete this product?")) {
//       await axios.delete(`http://127.0.0.1:8000/products/${id}`);
//       setProducts(products.filter(p => p.id !== id));
//     }
//   };

//   // Open edit modal
//   const handleEdit = (product) => {
//     setEditingProduct(product);
//     setFormData({
//       name: product.name,
//       price: product.price,
//       description: product.description,
//       image: null,
//       image_url: product.image_url.split("/").pop() || "", // store filename only
//     });
//   };

//   // Handle form changes
//   const handleChange = (e) => {
//     const { name, value, files } = e.target;
//     if (name === "image" && files.length > 0) {
//       setFormData(prev => ({ ...prev, image: files[0] }));
//     } else {
//       setFormData(prev => ({ ...prev, [name]: value }));
//     }
//   };

//   // Save edited product
//   const handleSave = async () => {
//     try {
//       const form = new FormData();
//       form.append("name", formData.name);
//       form.append("price", formData.price);
//       form.append("description", formData.description);

//       // Append new image if selected, else keep existing filename
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

//       // Update product list
//       setProducts(products.map(p => (p.id === editingProduct.id ? res.data : p)));
//       setEditingProduct(null);
//     } catch (err) {
//       console.error(err.response ? err.response.data : err.message);
//       alert("Error updating product! Check console for details.");
//     }
//   };

//   const handleCancel = () => setEditingProduct(null);

//   return (
//     <div className="manage-products-container">
//       <h2 className="page-title">🛍 Manage Products</h2>

//       <div className="product-grid">
//         {products.map(product => (
//           <div key={product.id} className="product-card">
//             <img src={product.image_url} alt={product.name} className="product-image"/>
//             <div className="product-info">
//               <h3>{product.name}</h3>
//               <p className="desc">{product.description}</p>
//               <p className="price">₹{product.price}</p>
//               <div className="action-buttons">
//                 <button className="edit-btn" onClick={() => handleEdit(product)}><FiEdit /></button>
//                 <button className="delete-btn" onClick={() => handleDelete(product.id)}><FiTrash2 /></button>
//               </div>
//             </div>
//           </div>
//         ))}
//       </div>

//       {/* Edit Modal */}
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
//             {/* Show current image if no new image selected */}
//             {formData.image_url && !formData.image && (
//               <img
//                 src={`http://127.0.0.1:8000/images/${formData.image_url}`}
//                 alt="Current"
//                 style={{ width: "100px", marginTop: "10px" }}
//               />
//             )}
//             <div className="modal-actions">
//               <button className="save-btn" onClick={handleSave}>Save</button>
//               <button className="cancel-btn" onClick={handleCancel}>Cancel</button>
//             </div>
//           </div>
//         </div>
//       )}
//     </div>
//   );
// };

// export default ManageProducts;
import React, { useEffect, useState } from "react";
import axios from "axios";
import { FiEdit, FiTrash2 } from "react-icons/fi";
import "./ManageProducts.css";

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

  useEffect(() => {
    axios
      .get("http://127.0.0.1:8000/products/")
      .then((res) => setProducts(res.data))
      .catch((err) => console.error(err));
  }, []);

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this product?")) {
      await axios.delete(`http://127.0.0.1:8000/products/${id}`);
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
      image_url: product.image_url.split("/").pop() || "",
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

      const res = await axios.put(
        `http://127.0.0.1:8000/products/${editingProduct.id}`,
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
      console.error(err);
      alert("Error updating product!");
    }
  };

  return (
    <div className="manage-products-container">
      <h2 className="page-title">🛍 Manage Products</h2>

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
                <button className="edit-btn">
                  <FiEdit />
                </button>

                {/* 🔴 DELETE BUTTON WITH RED ICON */}
                <button
                  className="delete-btn"
                  onClick={() => handleDelete(product.id)}
                >
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

            <input
              type="text"
              name="name"
              placeholder="Name"
              value={formData.name}
              onChange={handleChange}
            />

            <input
              type="number"
              name="price"
              placeholder="Price"
              value={formData.price}
              onChange={handleChange}
            />

            <input
              type="text"
              name="description"
              placeholder="Description"
              value={formData.description}
              onChange={handleChange}
            />

            <input
              type="file"
              name="image"
              accept="image/*"
              onChange={handleChange}
            />

            {formData.image_url && !formData.image && (
              <img
                src={`http://127.0.0.1:8000/images/${formData.image_url}`}
                alt="Current"
                style={{ width: "100px", marginTop: "10px" }}
              />
            )}

            <div className="modal-actions">
              <button className="save-btn" onClick={handleSave}>
                Save
              </button>
              <button
                className="cancel-btn"
                onClick={() => setEditingProduct(null)}
              >
                Cancel
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default ManageProducts;
