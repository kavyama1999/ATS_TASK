
// import React, { useState } from "react";
// import { Link, useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./UserLogin.css";

// const UserLogin = () => {
//   const navigate = useNavigate();
//   const [form, setForm] = useState({
//     email: "",
//     password: "",
//   });
//   const [message, setMessage] = useState("");

//   const handleChange = (e) => {
//     setForm({ ...form, [e.target.name]: e.target.value });
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     try {
//       const response = await api.post("/login/", form);

//       localStorage.setItem("user", JSON.stringify(response.data));
//       localStorage.setItem("user_id", response.data.user_id);

//       setMessage("✅ Login successful!");
//       setTimeout(() => navigate("/"), 1200);
//     } catch (error) {
//       console.error("Login failed:", error);
//       setMessage("❌ Invalid email or password.");
//     }
//   };

//   return (
//     <div className="login-container">

//       {/* === TOP-RIGHT TOAST MESSAGE === */}
//       {message && (
//         <div
//           className={`toast-message ${
//             message.includes("Invalid") ? "toast-error" : ""
//           }`}
//         >
//           {message}
//         </div>
//       )}

//       <div className="login-card">
//         <h2>🔐 User Login</h2>

//         <form onSubmit={handleSubmit}>
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

//           <div className="forgot-text">
//             <Link to="/forgot-password" className="forgot-link">
//               Forgot Password?
//             </Link>
//           </div>

//           <button type="submit">Login</button>
//         </form>

//         <p className="register-text">
//           Don’t have an account?{" "}
//           <Link to="/register" className="register-link">
//             Register here
//           </Link>
//         </p>
//       </div>
//     </div>
//   );
// };

// export default UserLogin;


import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/axios";
import "./UserLogin.css";

const UserLogin = () => {
  const navigate = useNavigate();
  const [form, setForm] = useState({
    email: "",
    password: "",
  });
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false); // ✅ loading state

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    // ❌ Email must be lowercase
    if (form.email !== form.email.toLowerCase()) {
      setMessage("❌ Invalid Email ");
      return;
    }

    setLoading(true); // start loading

    try {
      const response = await api.post("/login/", form);

      localStorage.setItem("user", JSON.stringify(response.data));
      localStorage.setItem("user_id", response.data.user_id);

      setMessage("✅ Login successful!");
      setTimeout(() => navigate("/"), 1200);
    } catch (error) {
      console.error("Login failed:", error);
      setMessage("❌ Invalid email or password.");
    } finally {
      setLoading(false); // stop loading
    }
  };

  return (
    <div className="login-container">
      {message && (
        <div
          className={`toast-message ${message.includes("Invalid") || message.includes("lowercase")
            ? "toast-error"
            : ""
            }`}
        >
          {message}
        </div>
      )}

      <div className="login-card">
        <h2>🔐 User Login</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            value={form.email}
            onChange={handleChange}
            required
            disabled={loading} // ✅ disable input while loading
          />

          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={form.password}
            onChange={handleChange}
            required
            disabled={loading} // ✅ disable input while loading
          />

          <div className="forgot-text">
            <Link to="/forgot-password" className="forgot-link">
              Forgot Password?
            </Link>
          </div>

          <button
            type="submit"
            disabled={loading} // ✅ disable button while loading
            style={{
              cursor: loading ? "not-allowed" : "pointer", // just change cursor
            }}
          >
            {loading ? "Logging in..." : "Login"}
          </button>

        </form>

        <p className="register-text">
          Don’t have an account?{" "}
          <Link to="/register" className="register-link">
            Register here
          </Link>
        </p>
      </div>
    </div>
  );
};

export default UserLogin;
