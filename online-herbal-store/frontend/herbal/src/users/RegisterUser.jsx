


import React, { useState } from "react";
import { Link } from "react-router-dom";
import api from "../api/axios";
import "./RegisterUser.css";

const RegisterUser = () => {
  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
    address: "",
    contact_number: "",
  });

  const [message, setMessage] = useState("");
  const [passwordError, setPasswordError] = useState(""); // ✅ password error
  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    let { name, value } = e.target;

    if (name === "contact_number") {
      if (!/^\d*$/.test(value)) return;
      if (value.length > 10) return;
    }

    setForm({ ...form, [name]: value });

    // ✅ Password validation live
    if (name === "password") {
      if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(value)) {
        setPasswordError("❌ Please enter a strong password");
      } else {
        setPasswordError(""); // strong password, remove message
      }
    }
  };

  const isValidEmail = (email) => {
    return /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(email);
  };

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
    <div className="register-container">
      {message && (
        <div
          className={`toast-message ${message.includes("❌") ? "toast-error" : ""}`}
        >
          {message}
        </div>
      )}

      <div className="register-card">
        <h2>👤 Create Account</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Enter Username"
            value={form.username}
            onChange={handleChange}
            required
            disabled={loading}
          />

          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            value={form.email}
            onChange={handleChange}
            required
            disabled={loading}
          />

          <input
            type="text"
            name="address"
            placeholder="Enter Address"
            value={form.address}
            onChange={handleChange}
            required
            disabled={loading}
          />

          <input
            type="text"
            name="contact_number"
            placeholder="Enter Contact Number"
            value={form.contact_number}
            onChange={handleChange}
            required
            disabled={loading}
          />

          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={form.password}
            onChange={handleChange}
            required
            disabled={loading}
          />
          {passwordError && (
            <p style={{ fontSize: "0.9rem", color: "red" }}>{passwordError}</p>
          )}

          <button
            type="submit"
            disabled={loading}
            style={{
              cursor: loading ? "not-allowed" : "pointer",
            }}
          >
            {loading ? "Registering..." : "Register"}
          </button>
        </form>

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
