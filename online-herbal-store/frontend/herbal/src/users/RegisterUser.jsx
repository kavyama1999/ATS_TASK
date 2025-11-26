
// import React, { useState } from "react";
// import { Link } from "react-router-dom";
// import api from "../api/axios";
// import "./RegisterUser.css";

// const RegisterUser = () => {
//   const [form, setForm] = useState({
//     username: "",
//     email: "",
//     password: "",
//     address: "",
//     contact_number: "",
//   });

//   const [message, setMessage] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const [loading, setLoading] = useState(false);

//   // ---------------- HANDLE CHANGE ----------------
//   const handleChange = (e) => {
//     let { name, value } = e.target;

//     // Only digits + max 10 digits for contact
//     if (name === "contact_number") {
//       if (!/^\d*$/.test(value)) return;
//       if (value.length > 10) return;
//     }

//     setForm({ ...form, [name]: value });

//     // Password strong validation
//     if (name === "password") {
//       if (
//         !/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(value)
//       ) {
//         setPasswordError("❌ Please enter a strong password");
//       } else {
//         setPasswordError("");
//       }
//     }
//   };

//   // ---------------- EMAIL VALIDATION ----------------
//   const isValidEmail = (email) => {
//     return /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(email);
//   };

//   // ---------------- HANDLE SUBMIT ----------------
//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     if (form.contact_number.length !== 10) {
//       setMessage("❌ Contact number must be exactly 10 digits!");
//       return;
//     }

//     if (!isValidEmail(form.email)) {
//       setMessage("❌ Invalid email! Use lowercase letters only.");
//       return;
//     }

//     if (passwordError) {
//       setMessage(passwordError);
//       return;
//     }

//     if (/\s/.test(form.password)) {
//       setMessage("❌ Password cannot contain spaces!");
//       return;
//     }

//     setLoading(true);
//     try {
//       const payload = { ...form, email: form.email.toLowerCase() };
//       await api.post("/users/", payload);

//       setMessage("✅ Registration successful!");

//       setForm({
//         username: "",
//         email: "",
//         password: "",
//         address: "",
//         contact_number: "",
//       });

//       setTimeout(() => setMessage(""), 3000);
//     } catch (error) {
//       console.error("Error creating user:", error);
//       setMessage("❌ User already exists or server error.");
//     } finally {
//       setLoading(false);
//     }
//   };

//   return (
//     <div className="register-container">
//       {message && (
//         <div
//           className={`toast-message ${
//             message.includes("❌") ? "toast-error" : ""
//           }`}
//         >
//           {message}
//         </div>
//       )}

//       <div className="register-card">
//         <h2>👤 Create Account</h2>

//         <form onSubmit={handleSubmit}>
//           <input
//             type="text"
//             name="username"
//             placeholder="Enter Username"
//             value={form.username}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />

//           <input
//             type="email"
//             name="email"
//             placeholder="Enter Email"
//             value={form.email}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />

//           <input
//             type="text"
//             name="address"
//             placeholder="Enter Address"
//             value={form.address}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />

//           <input
//             type="text"
//             name="contact_number"
//             placeholder="Enter Contact Number"
//             value={form.contact_number}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />

//           {/* PASSWORD FIELD - SPACE NOT ALLOWED */}
//           <input
//             type="password"
//             name="password"
//             placeholder="Enter Password"
//             value={form.password}
//             onChange={(e) => {
//               if (e.target.value.includes(" ")) {
//                 setPasswordError("❌ Password cannot contain spaces!");
//                 return;
//               }

//               setPasswordError("");
//               handleChange(e);
//             }}
//             required
//             disabled={loading}
//           />

//           {passwordError && (
//             <p style={{ fontSize: "0.9rem", color: "red" }}>{passwordError}</p>
//           )}

//           <button
//             type="submit"
//             disabled={loading}
//             style={{
//               cursor: loading ? "not-allowed" : "pointer",
//             }}
//           >
//             {loading ? "Registering..." : "Register"}
//           </button>
//         </form>

//         <p className="login-text">
//           Already registered?{" "}
//           <Link to="/user-login" className="login-link">
//             Login here
//           </Link>
//         </p>
//       </div>
//     </div>
//   );
// };

// export default RegisterUser;
// import React, { useState } from "react";
// import { Link } from "react-router-dom";
// import api from "../api/axios";
// import "./RegisterUser.css";

// const RegisterUser = () => {
//   const [form, setForm] = useState({
//     username: "",
//     email: "",
//     password: "",
//     address: "",
//     contact_number: "",
//   });

//   const [message, setMessage] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const [loading, setLoading] = useState(false);

//   const handleChange = (e) => {
//     let { name, value } = e.target;

//     if (name === "contact_number") {
//       if (!/^\d*$/.test(value)) return;
//       if (value.length > 10) return;
//     }

//     setForm({ ...form, [name]: value });

//     if (name === "password") {
//       if (
//         !/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(value)
//       ) {
//         setPasswordError("❌ Please enter a strong password");
//       } else {
//         setPasswordError("");
//       }
//     }
//   };

//   const isValidEmail = (email) => {
//     return /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(email);
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     if (form.contact_number.length !== 10) {
//       setMessage("❌ Contact number must be exactly 10 digits!");
//       return;
//     }

//     if (!isValidEmail(form.email)) {
//       setMessage("❌ Invalid email! Use lowercase letters only.");
//       return;
//     }

//     if (passwordError) {
//       setMessage(passwordError);
//       return;
//     }

//     if (/\s/.test(form.password)) {
//       setMessage("❌ Password cannot contain spaces!");
//       return;
//     }

//     setLoading(true);

//     try {
//       const payload = { ...form, email: form.email.toLowerCase() };
//       await api.post("/users/", payload);

//       setMessage("✅ Registration successful!");

//       setForm({
//         username: "",
//         email: "",
//         password: "",
//         address: "",
//         contact_number: "",
//       });

//       setTimeout(() => setMessage(""), 3000);
//     } catch (error) {
//       console.error("Error creating user:", error);
//       setMessage("❌ User already exists or server error.");
//     } finally {
//       setLoading(false);
//     }
//   };

//  return (
//   <div className="register-wrapper">

//     <div className="register-glass">
//       <h2 className="title">Create Account</h2>

//       {/* ⭐ Success / Error message inside form */}
//       {message && (
//         <div
//           className={`form-message ${
//             message.includes("❌") ? "error" : "success"
//           }`}
//         >
//           {message}
//         </div>
//       )}

//       <form className="register-form" onSubmit={handleSubmit}>

//         <div className="input-group">
//           <label>Username</label>
//           <input
//             type="text"
//             name="username"
//             placeholder="Enter Username"
//             value={form.username}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />
//         </div>

//         <div className="input-group">
//           <label>Email</label>
//           <input
//             type="email"
//             name="email"
//             placeholder="Enter Email"
//             value={form.email}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />
//         </div>

//         <div className="input-group">
//           <label>Address</label>
//           <input
//             type="text"
//             name="address"
//             placeholder="Enter Address"
//             value={form.address}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />
//         </div>

//         <div className="input-group">
//           <label>Contact Number</label>
//           <input
//             type="text"
//             name="contact_number"
//             placeholder="Enter Contact Number"
//             value={form.contact_number}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />
//         </div>

//         <div className="input-group">
//           <label>Password</label>
//           <input
//             type="password"
//             name="password"
//             placeholder="Enter Password"
//             value={form.password}
//             onChange={(e) => {
//               if (e.target.value.includes(" ")) {
//                 setPasswordError("❌ Password cannot contain spaces!");
//                 return;
//               }
//               setPasswordError("");
//               handleChange(e);
//             }}
//             required
//             disabled={loading}
//           />
//         </div>

//         {passwordError && <p className="error-text">{passwordError}</p>}

//         <button className="btn-register" type="submit" disabled={loading}>
//           {loading ? "Registering..." : "Register"}
//         </button>
//       </form>

//       <p className="login-hint">
//         Already registered? <Link to="/user-login">Login here</Link>
//       </p>
//     </div>
//   </div>
// );

// };

// export default RegisterUser;


// import React, { useState } from "react";
// import { Link } from "react-router-dom";
// import api from "../api/axios";
// import "./RegisterUser.css";
// import { FaEye, FaEyeSlash } from "react-icons/fa";

// const RegisterUser = () => {
//   const [form, setForm] = useState({
//     username: "",
//     email: "",
//     password: "",
//     address: "",
//     contact_number: "",
//   });

//   const [message, setMessage] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const [loading, setLoading] = useState(false);
//   const [showPassword, setShowPassword] = useState(false);

//   const handleChange = (e) => {
//     let { name, value } = e.target;

//     if (name === "contact_number") {
//       if (!/^\d*$/.test(value)) return;
//       if (value.length > 10) return;
//     }

//     setForm({ ...form, [name]: value });

//     if (name === "password") {
//       if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(value)) {
//         setPasswordError("❌ Please enter a strong password");
//       } else {
//         setPasswordError("");
//       }
//     }
//   };

//   const isValidEmail = (email) =>
//     /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(email);

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     if (form.contact_number.length !== 10) {
//       setMessage("❌ Contact number must be exactly 10 digits!");
//       return;
//     }

//     if (!isValidEmail(form.email)) {
//       setMessage("❌ Invalid email! Use lowercase letters only.");
//       return;
//     }

//     if (passwordError) {
//       setMessage(passwordError);
//       return;
//     }

//     if (/\s/.test(form.password)) {
//       setMessage("❌ Password cannot contain spaces!");
//       return;
//     }

//     setLoading(true);

//     try {
//       const payload = { ...form, email: form.email.toLowerCase() };
//       await api.post("/users/", payload);

//       setMessage("✅ Registration successful!");

//       setForm({
//         username: "",
//         email: "",
//         password: "",
//         address: "",
//         contact_number: "",
//       });

//       setTimeout(() => setMessage(""), 3000);
//     } catch (error) {
//       console.error("Error creating user:", error);
//       setMessage("❌ User already exists or server error.");
//     } finally {
//       setLoading(false);
//     }
//   };

//   return (
//     <div className="register-wrapper">

//       <div className="register-glass">
//         <h2 className="title">Create Account</h2>

//         {message && (
//           <div
//             className={`form-message ${
//               message.includes("❌") ? "error" : "success"
//             }`}
//           >
//             {message}
//           </div>
//         )}

//         <form className="register-form" onSubmit={handleSubmit}>

//           <div className="input-group">
//             <label>Username</label>
//             <input
//               type="text"
//               name="username"
//               placeholder="Enter Username"
//               value={form.username}
//               onChange={handleChange}
//               required
//               disabled={loading}
//             />
//           </div>

//           <div className="input-group">
//             <label>Email</label>
//             <input
//               type="email"
//               name="email"
//               placeholder="Enter Email"
//               value={form.email}
//               onChange={handleChange}
//               required
//               disabled={loading}
//             />
//           </div>

//           <div className="input-group">
//             <label>Address</label>
//             <input
//               type="text"
//               name="address"
//               placeholder="Enter Address"
//               value={form.address}
//               onChange={handleChange}
//               required
//               disabled={loading}
//             />
//           </div>

//           <div className="input-group">
//             <label>Contact Number</label>
//             <input
//               type="text"
//               name="contact_number"
//               placeholder="Enter Contact Number"
//               value={form.contact_number}
//               onChange={handleChange}
//               required
//               disabled={loading}
//             />
//           </div>

//           {/* ⭐ Password With Icon */}
//           <div className="input-group password-box">
//             <label>Password</label>
//             <div className="password-wrapper">
//               <input
//                 type={showPassword ? "text" : "password"}
//                 name="password"
//                 placeholder="Enter Password"
//                 value={form.password}
//                 onChange={(e) => {
//                   if (e.target.value.includes(" ")) {
//                     setPasswordError("❌ Password cannot contain spaces!");
//                     return;
//                   }
//                   setPasswordError("");
//                   handleChange(e);
//                 }}
//                 required
//                 disabled={loading}
//               />
//               <span
//                 className="password-icon"
//                 onClick={() => setShowPassword(!showPassword)}
//               >
//                 {showPassword ? <FaEyeSlash /> : <FaEye />}
//               </span>
//             </div>
//           </div>

//           {passwordError && <p className="error-text">{passwordError}</p>}

//           <button className="btn-register" type="submit" disabled={loading}>
//             {loading ? "Registering..." : "Register"}
//           </button>
//         </form>

//         <p className="login-hint">
//           Already registered? <Link to="/user-login">Login here</Link>
//         </p>
//       </div>
//     </div>
//   );
// };

// export default RegisterUser;


import React, { useState } from "react";
import { Link } from "react-router-dom";
import api from "../api/axios";
import "./RegisterUser.css";
import { FaEye, FaEyeSlash } from "react-icons/fa";

const RegisterUser = () => {
  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
    address: "",
    contact_number: "",
  });

  const [message, setMessage] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [loading, setLoading] = useState(false);
  const [showPassword, setShowPassword] = useState(false);

  const handleChange = (e) => {
    let { name, value } = e.target;

    if (name === "contact_number") {
      if (!/^\d*$/.test(value)) return;
      if (value.length > 10) return;
    }

    setForm({ ...form, [name]: value });

    if (name === "password") {
      if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(value)) {
        setPasswordError("❌ Please enter a strong password");
      } else {
        setPasswordError("");
      }
    }
  };

  const isValidEmail = (email) =>
    /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(email);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    if (form.contact_number.length !== 10) {
      setMessage("❌ Contact number must be exactly 10 digits!");
      return;
    }

    if (!isValidEmail(form.email)) {
      setMessage("❌ Invalid email! Use lowercase letters only.");
      return;
    }

    if (passwordError) {
      setMessage(passwordError);
      return;
    }

    if (/\s/.test(form.password)) {
      setMessage("❌ Password cannot contain spaces!");
      return;
    }

    setLoading(true);

    try {
      const payload = { ...form, email: form.email.toLowerCase() };
      await api.post("/users/", payload);

      setMessage("✅ Registration successful!");
      setForm({
        username: "",
        email: "",
        password: "",
        address: "",
        contact_number: "",
      });

      setTimeout(() => setMessage(""), 3000);
    } catch (error) {
      console.error("Error creating user:", error);
      setMessage("❌ User already exists or server error.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="register-wrapper">
      <div className="register-glass">
        <h2 className="title">Create Account</h2>

        {message && (
          <div
            className={`form-message ${
              message.includes("❌") ? "error" : "success"
            }`}
          >
            {message}
          </div>
        )}

        <form className="register-form" onSubmit={handleSubmit}>
          <div className="input-group">
            <label>Username</label>
            <input
              type="text"
              name="username"
              placeholder="Enter Username"
              value={form.username}
              onChange={handleChange}
              required
              disabled={loading}
            />
          </div>

          <div className="input-group">
            <label>Email</label>
            <input
              type="email"
              name="email"
              placeholder="Enter Email"
              value={form.email}
              onChange={handleChange}
              required
              disabled={loading}
            />
          </div>

          <div className="input-group">
            <label>Address</label>
            <input
              type="text"
              name="address"
              placeholder="Enter Address"
              value={form.address}
              onChange={handleChange}
              required
              disabled={loading}
            />
          </div>

          <div className="input-group">
            <label>Contact Number</label>
            <input
              type="text"
              name="contact_number"
              placeholder="Enter Contact Number"
              value={form.contact_number}
              onChange={handleChange}
              required
              disabled={loading}
            />
          </div>

          {/* Password Field with Icon */}
          <div className="input-group password-box">
            <label>Password</label>
            <div className="password-wrapper">
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                placeholder="Enter Password"
                value={form.password}
                onChange={(e) => {
                  if (e.target.value.includes(" ")) {
                    setPasswordError("❌ Password cannot contain spaces!");
                    return;
                  }
                  setPasswordError("");
                  handleChange(e);
                }}
                required
                disabled={loading}
              />
              <span
                className="password-icon"
                onClick={() => setShowPassword(!showPassword)}
              >
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </div>
          </div>

          {passwordError && <p className="error-text">{passwordError}</p>}

          <button className="btn-register" type="submit" disabled={loading}>
            {loading ? "Registering..." : "Register"}
          </button>
        </form>

        <p className="login-hint">
          Already registered? <Link to="/user-login">Login here</Link>
        </p>
      </div>
    </div>
  );
};

export default RegisterUser;
