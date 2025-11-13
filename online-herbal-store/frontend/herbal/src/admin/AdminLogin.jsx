import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./AdminLogin.css";

const AdminLogin = () => {
  const navigate = useNavigate();
  const [login, setLogin] = useState({ email: "", password: "" });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post("http://127.0.0.1:8000/admin/login", login);
      if (res.status === 200) {
        alert("Login Successful");
        navigate("/admindashboard");
      }
    } catch (err) {
      alert("Invalid credentials");
    }
  };

  return (
    <div className="admin-login-page">
      <div className="login-card">
        <h2>🌿 Admin Login</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Enter your email"
            value={login.email}
            onChange={(e) => setLogin({ ...login, email: e.target.value })}
            required
          />
          <input
            type="password"
            placeholder="Enter your password"
            value={login.password}
            onChange={(e) => setLogin({ ...login, password: e.target.value })}
            required
          />
          <button type="submit">Login</button>
        </form>
      </div>
    </div>
  );
};

export default AdminLogin;
