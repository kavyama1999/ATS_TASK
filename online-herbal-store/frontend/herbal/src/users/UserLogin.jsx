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

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    try {
      const response = await api.post("/login/", form);

      // ✅ Save both user and user_id consistently
      localStorage.setItem("user", JSON.stringify(response.data));
      localStorage.setItem("user_id", response.data.user_id); // 👈 use user_id not userId

      setMessage("✅ Login successful!");
      setTimeout(() => navigate("/"), 1000); // redirect to home after 1s
    } catch (error) {
      console.error("Login failed:", error);
      setMessage("❌ Invalid email or password.");
    }
  };

  return (
    <div className="login-container">
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
          />
          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={form.password}
            onChange={handleChange}
            required
          />
          <button type="submit">Login</button>
        </form>

        {message && <p className="message">{message}</p>}

        {/* Optional register link */}
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

