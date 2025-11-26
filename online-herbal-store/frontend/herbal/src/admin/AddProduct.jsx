
// import { useState } from "react";
// import api from "../api/axios";   // ✅ USE axios instance
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
//       const response = await api.post("/products/upload", formData);

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
import api from "../api/axios";   // ✅ axios instance
import "./AdminDashboard.css";
import "./AddProduct.css";

function AddProduct() {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [imageFile, setImageFile] = useState(null);
  const [imagePreview, setImagePreview] = useState(null);

  const [errors, setErrors] = useState({
    name: "",
    price: "",
    image: "",
    duplicate: ""
  });

  // Handle image change and preview
  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (!file) return;

    const allowedTypes = ["image/jpeg", "image/jpg", "image/png"];
    if (!allowedTypes.includes(file.type)) {
      setErrors(prev => ({ ...prev, image: "Unsupported file type. Only JPG, JPEG, PNG allowed." }));
      setImageFile(null);
      setImagePreview(null);
      return;
    }

    setErrors(prev => ({ ...prev, image: "" }));
    setImageFile(file);

    // Show image preview
    const reader = new FileReader();
    reader.onload = () => setImagePreview(reader.result);
    reader.readAsDataURL(file);
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Reset duplicate error
    setErrors(prev => ({ ...prev, duplicate: "" }));

    // Validate price
    if (Number(price) <= 0) {
      setErrors(prev => ({ ...prev, price: "Price must be a positive number." }));
      return;
    }

    // Check for duplicate product name
    try {
      const check = await api.post("/products/check-name", { name: name.trim() });
      if (check.data.exists) {
        setErrors(prev => ({ ...prev, duplicate: "Product with this name already exists." }));
        return;
      }
    } catch (err) {
      console.error("Error checking duplicate:", err);
      alert("Error checking product name.");
      return;
    }

    // Prepare form data for upload
    const formData = new FormData();
    formData.append("name", name.trim());
    formData.append("description", description);
    formData.append("price", price);
    formData.append("image", imageFile);

    try {
      await api.post("/products/upload", formData);

      alert("✅ Product Added Successfully!");
      setName("");
      setDescription("");
      setPrice("");
      setImageFile(null);
      setImagePreview(null);
      setErrors({ name: "", price: "", image: "", duplicate: "" });

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
          <input 
            type="text" 
            value={name} 
            onChange={(e) => setName(e.target.value)} 
            required 
          />
          {errors.duplicate && <p className="error-msg">{errors.duplicate}</p>}

          <label>Description</label>
          <textarea 
            rows="4" 
            value={description} 
            onChange={(e) => setDescription(e.target.value)} 
            required
          ></textarea>

          <label>Price (₹)</label>
          <input 
            type="number" 
            value={price} 
            onChange={(e) => setPrice(e.target.value)} 
            required 
          />
          {errors.price && <p className="error-msg">{errors.price}</p>}

          <label>Upload Product Image</label>
          <input 
            type="file" 
            accept="image/jpeg, image/jpg, image/png" 
            onChange={handleImageChange} 
            required 
          />
          {errors.image && <p className="error-msg">{errors.image}</p>}

          {/* Image Preview */}
          {imagePreview && (
            <div className="image-preview">
              <img src={imagePreview} alt="Preview" />
            </div>
          )}

          <button type="submit" className="submit-btn">Add Product</button>
        </form>
      </main>
    </div>
  );
}

export default AddProduct;
