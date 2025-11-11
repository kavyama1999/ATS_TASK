import React from "react";
import { useNavigate } from "react-router-dom";
import { FiLogOut } from "react-icons/fi"; // logout icon

const AdminHeader = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    // You can also clear localStorage or auth tokens here if you use them
    localStorage.removeItem("adminToken");
    navigate("/"); // redirect to normal home page
  };

  return (
    <header className="bg-green-700 text-white flex justify-between items-center px-8 py-4 shadow-md">
      <h1 className="text-xl font-bold tracking-wide">🌿 Herbal Admin Panel</h1>

      <button
        onClick={handleLogout}
        className="flex items-center gap-2 bg-green-800 hover:bg-green-900 px-4 py-2 rounded-lg transition-all"
      >
        <FiLogOut className="text-lg" />
        <span className="font-medium">Logout</span>
      </button>
    </header>
  );
};

export default AdminHeader;
