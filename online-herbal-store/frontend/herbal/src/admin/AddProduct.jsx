



// import { useState } from "react";
// import "./AdminDashboard.css";
// import "./AddProduct.css";

// function AddProduct() {
//   const [name, setName] = useState("");
//   const [description, setDescription] = useState("");
//   const [price, setPrice] = useState("");
//   const [imageFile, setImageFile] = useState(null);

//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     const formData = new FormData();
//     formData.append("name", name);
//     formData.append("description", description);
//     formData.append("price", price);
//     formData.append("image", imageFile);

//     try {
//       const response = await fetch("http://localhost:8000/products/upload", {
//         method: "POST",
//         body: formData,
//       });

//       if (!response.ok) {
//         alert("Failed to add product. Check backend.");
//         return;
//       }

//       alert("✅ Product Added Successfully!");
//       setName("");
//       setDescription("");
//       setPrice("");
//       setImageFile(null);

//     } catch (error) {
//       alert("Error adding product: " + error);
//     }
//   };

//   return (
//     <div className="admin-layout">
//       <main className="main-content">
//         <h1 className="page-title">➕ Add New Product</h1>

//         <form className="add-product-form" onSubmit={handleSubmit}>
          
//           <label>Product Name</label>
//           <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />

//           <label>Description</label>
//           <textarea rows="4" value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>

//           <label>Price (₹)</label>
//           <input type="number" value={price} onChange={(e) => setPrice(e.target.value)} required />

//           <label>Upload Product Image</label>
//           <input type="file" accept="image/*" onChange={(e) => setImageFile(e.target.files[0])} required />

//           <button type="submit" className="submit-btn">Add Product</button>
//         </form>
//       </main>
//     </div>
//   );
// }

// export default AddProduct;

import { useState } from "react";
import api from "../api/axios";   // ✅ USE axios instance
import "./AdminDashboard.css";
import "./AddProduct.css";

function AddProduct() {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [imageFile, setImageFile] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("name", name);
    formData.append("description", description);
    formData.append("price", price);
    formData.append("image", imageFile);

    try {
      const response = await api.post("/products/upload", formData);

      alert("✅ Product Added Successfully!");
      setName("");
      setDescription("");
      setPrice("");
      setImageFile(null);

    } catch (error) {
      alert("Error adding product: " + error);
    }
  };

  return (
    <div className="admin-layout">
      <main className="main-content">
        <h1 className="page-title">➕ Add New Product</h1>

        <form className="add-product-form" onSubmit={handleSubmit}>
          <label>Product Name</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />

          <label>Description</label>
          <textarea rows="4" value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>

          <label>Price (₹)</label>
          <input type="number" value={price} onChange={(e) => setPrice(e.target.value)} required />

          <label>Upload Product Image</label>
          <input type="file" accept="image/*" onChange={(e) => setImageFile(e.target.files[0])} required />

          <button type="submit" className="submit-btn">Add Product</button>
        </form>
      </main>
    </div>
  );
}

export default AddProduct;
