

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios"; 
import { FaEye, FaEyeSlash } from "react-icons/fa";
import "./AdminLogin.css";

const AdminLogin = () => {
  const navigate = useNavigate();
  const [login, setLogin] = useState({ email: "", password: "" });
  const [showPassword, setShowPassword] = useState(false);
  const [message, setMessage] = useState("");

  const isValidEmail = (email) =>
    /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(email);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    // Lowercase email validation
    if (!isValidEmail(login.email)) {
      setMessage("❌ Invalid email .");
      return;
    }

    try {
      const res = await api.post("/admin/login", login);
      if (res.status === 200) {
        setMessage("✅ Login Successful!");
        setTimeout(() => navigate("/admindashboard"), 1000); // navigate after 1s
      }
    } catch (err) {
      setMessage("❌ Invalid credentials");
    }
  };

  return (
    <div className="admin-login-page">
      <div className="login-card">
        <h2>🌿 Admin Login</h2>

        {message && (
          <div
            className={`form-message ${
              message.includes("❌") ? "error" : "success"
            }`}
          >
            {message}
          </div>
        )}

        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <label>Email</label>
            <input
              type="email"
              placeholder="Enter your email"
              value={login.email}
              onChange={(e) => setLogin({ ...login, email: e.target.value })}
              required
            />
          </div>

          <div className="input-group password-box">
            <label>Password</label>
            <div className="password-wrapper">
              <input
                type={showPassword ? "text" : "password"}
                placeholder="Enter your password"
                value={login.password}
                onChange={(e) =>
                  setLogin({ ...login, password: e.target.value })
                }
                required
              />
              <span
                className="password-icon"
                onClick={() => setShowPassword(!showPassword)}
              >
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </div>
          </div>

          <button type="submit">Login</button>
        </form>
      </div>
    </div>
  );
};

export default AdminLogin;
