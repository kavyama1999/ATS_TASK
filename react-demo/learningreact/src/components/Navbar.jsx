import React from "react";
import { Link } from "react-router-dom";
import "../Styles/NavBar.css";

export default function Navbar() {
  return (
    <nav className="navbar">
      <div className="nav-links">
        <Link to="/">Home</Link>
        <Link to="/users">Users</Link>
      </div>
    </nav>
  );
}
