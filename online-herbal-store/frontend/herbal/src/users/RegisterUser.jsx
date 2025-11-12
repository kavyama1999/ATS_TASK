// import React, { useState } from "react";
// import api from "../api/axios";
// import "./RegisterUser.css"; // 🌿 custom CSS

// const RegisterUser = () => {
//   const [form, setForm] = useState({
//     username: "",
//     email: "",
//     password: "",
//   });
//   const [message, setMessage] = useState("");

//   const handleChange = (e) => {
//     setForm({ ...form, [e.target.name]: e.target.value });
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     try {
//       const response = await api.post("/users/", form);
//       setMessage(`✅ User created: ${response.data.username}`);
//       setForm({ username: "", email: "", password: "" });
//     } catch (error) {
//       console.error("Error creating user:", error);
//       setMessage("❌ Failed to create user.");
//     }
//   };

//   return (
//     <div className="register-container">
//       <div className="register-card">
//         <h2>👤 Create New User</h2>
//         <form onSubmit={handleSubmit}>
//           <input
//             type="text"
//             name="username"
//             placeholder="Enter Username"
//             value={form.username}
//             onChange={handleChange}
//             required
//           />
//           <input
//             type="email"
//             name="email"
//             placeholder="Enter Email"
//             value={form.email}
//             onChange={handleChange}
//             required
//           />
//           <input
//             type="password"
//             name="password"
//             placeholder="Enter Password"
//             value={form.password}
//             onChange={handleChange}
//             required
//           />
//           <button type="submit">Register</button>
//         </form>
//         {message && <p className="message">{message}</p>}
//       </div>
//     </div>
//   );
// };

// export default RegisterUser;

import React, { useState } from "react";
import { Link } from "react-router-dom"; // ✅ add this
import api from "../api/axios";
import "./RegisterUser.css";

const RegisterUser = () => {
  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
  });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await api.post("/users/", form);
      setMessage(`✅ User created: ${response.data.username}`);
      setForm({ username: "", email: "", password: "" });
    } catch (error) {
      console.error("Error creating user:", error);
      setMessage("❌ Failed to create user.");
    }
  };

  return (
    <div className="register-container">
      <div className="register-card">
        <h2>👤 Create New User</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Enter Username"
            value={form.username}
            onChange={handleChange}
            required
          />
          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            value={form.email}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={form.password}
            onChange={handleChange}
            required
          />
          <button type="submit">Register</button>
        </form>

        {message && <p className="message">{message}</p>}

        {/* ✅ Login link */}
        <p className="login-text">
          Already registered?{" "}
          <Link to="/user-login" className="login-link">
            Login here
          </Link>
        </p>
      </div>
    </div>
  );
};

export default RegisterUser;

