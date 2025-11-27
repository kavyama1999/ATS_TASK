


// import { useState } from "react";
// import api from "../api/axios";
// import "./AdminDashboard.css";
// import "./AddProduct.css";

// function AddProduct() {
//   const [name, setName] = useState("");
//   const [description, setDescription] = useState("");
//   const [price, setPrice] = useState("");
//   const [imageFile, setImageFile] = useState(null);
//   const [imagePreview, setImagePreview] = useState(null);
//   const [errors, setErrors] = useState({ price: "", image: "" });

//   // Handle image preview & validation
//   const handleImageChange = (e) => {
//     const file = e.target.files[0];
//     if (!file) return;

//     const allowedTypes = ["image/jpeg", "image/jpg", "image/png"];
//     if (!allowedTypes.includes(file.type)) {
//       setErrors(prev => ({ ...prev, image: "Unsupported file type. Only JPG, JPEG, PNG allowed." }));
//       setImageFile(null);
//       setImagePreview(null);
//       return;
//     }

//     setErrors(prev => ({ ...prev, image: "" }));
//     setImageFile(file);

//     const reader = new FileReader();
//     reader.onload = () => setImagePreview(reader.result);
//     reader.readAsDataURL(file);
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     // Price validation
//     if (Number(price) <= 0) {
//       setErrors(prev => ({ ...prev, price: "Price must be a positive number." }));
//       return;
//     }

//     if (!imageFile) {
//       setErrors(prev => ({ ...prev, image: "Please upload an image." }));
//       return;
//     }

//     const formData = new FormData();
//     formData.append("name", name.trim());
//     formData.append("description", description);
//     formData.append("price", price);
//     formData.append("image", imageFile);

//     try {
//       await api.post("/products/upload", formData);
//       alert("✅ Product Added Successfully!");
//       setName("");
//       setDescription("");
//       setPrice("");
//       setImageFile(null);
//       setImagePreview(null);
//       setErrors({ price: "", image: "" });

//     } catch (error) {
//       if (error.response && error.response.status === 400) {
//         alert(error.response.data.detail); // duplicate product or validation error
//       } else {
//         alert("Error adding product: " + error);
//       }
//     }
//   };

//   return (
//     <div className="admin-layout">
//       <main className="main-content">
//         <h1 className="page-title">➕ Add New Product</h1>

//         <form className="add-product-form" onSubmit={handleSubmit}>

//           <label>Product Name</label>
//           <input 
//             type="text" 
//             value={name} 
//             onChange={(e) => setName(e.target.value)} 
//             required 
//           />

//           <label>Description</label>
//           <textarea 
//             rows="4" 
//             value={description} 
//             onChange={(e) => setDescription(e.target.value)} 
//             required
//           ></textarea>

//           <label>Price (₹)</label>
//           <input 
//             type="number" 
//             value={price} 
//             onChange={(e) => setPrice(e.target.value)} 
//             required 
//           />
//           {errors.price && <p className="error-msg">{errors.price}</p>}

//           <label>Upload Product Image</label>
//           <input 
//             type="file" 
//             accept="image/jpeg, image/jpg, image/png" 
//             onChange={handleImageChange} 
//             required 
//           />
//           {errors.image && <p className="error-msg">{errors.image}</p>}

//           {imagePreview && (
//             <div className="image-preview">
//               <img src={imagePreview} alt="Preview" />
//             </div>
//           )}

//           <button type="submit" className="submit-btn">
//             Add Product
//           </button>
//         </form>
//       </main>
//     </div>
//   );
// }

// export default AddProduct;
import { useState } from "react";
import api from "../api/axios";
import "./AdminDashboard.css";
import "./AddProduct.css";

function AddProduct() {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [imageFile, setImageFile] = useState(null);
  const [imagePreview, setImagePreview] = useState(null);
  const [errors, setErrors] = useState({ price: "", image: "" });

  // NEW STATES FOR POPUP MESSAGE
  const [msg, setMsg] = useState("");
  const [msgType, setMsgType] = useState(""); // success | error

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

    const reader = new FileReader();
    reader.onload = () => setImagePreview(reader.result);
    reader.readAsDataURL(file);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Price validation
    if (Number(price) <= 0) {
      setErrors(prev => ({ ...prev, price: "Price must be a positive number." }));
      return;
    }

    if (!imageFile) {
      setErrors(prev => ({ ...prev, image: "Please upload an image." }));
      return;
    }

    const formData = new FormData();
    formData.append("name", name.trim());
    formData.append("description", description);
    formData.append("price", price);
    formData.append("image", imageFile);

    try {
      await api.post("/products/upload", formData);

      // SHOW SUCCESS MESSAGE
      setMsg("✅ Product Added Successfully!");
      setMsgType("success");

      // reset fields
      setName("");
      setDescription("");
      setPrice("");
      setImageFile(null);
      setImagePreview(null);
      setErrors({ price: "", image: "" });

      setTimeout(() => setMsg(""), 3000);

    } catch (error) {
      if (error.response && error.response.status === 400) {

        // SHOW DUPLICATE PRODUCT MESSAGE
        setMsg(error.response.data.detail);
        setMsgType("error");
        setTimeout(() => setMsg(""), 3000);

      } else {
        setMsg("❌ Error adding product");
        setMsgType("error");
        setTimeout(() => setMsg(""), 3000);
      }
    }
  };

  return (
    <div className="admin-layout">
      <main className="main-content">
        <h1 className="page-title">➕ Add New Product</h1>

        <form className="add-product-form" onSubmit={handleSubmit}>

          {/* POPUP MESSAGE BOX ABOVE FIELDS */}
          {msg && (
            <div className={`form-msg ${msgType}`}>
              {msg}
            </div>
          )}

          <label>Product Name</label>
          <input 
            type="text" 
            value={name} 
            onChange={(e) => setName(e.target.value)} 
            required 
          />

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

          {imagePreview && (
            <div className="image-preview">
              <img src={imagePreview} alt="Preview" />
            </div>
          )}

          <button type="submit" className="submit-btn">
            Add Product
          </button>
        </form>
      </main>
    </div>
  );
}

export default AddProduct;
