

// import { Link, Outlet, useNavigate } from "react-router-dom";
// import { useEffect, useState } from "react";
// import {
//   IoLogOutOutline,
//   IoHomeOutline,
//   IoSettingsOutline,
//   IoPeopleOutline,
//   IoCartOutline
// } from "react-icons/io5";

// import api from "../api/axios";
// import "./AdminDashboard.css";

// function AdminDashboard() {
//   const navigate = useNavigate();

//   const handleLogout = () => {
//     localStorage.removeItem("adminToken");
//     navigate("/");
//   };

//   return (
//     <div className="admin-layout">

//       {/* 🌿 Header */}
//       <header className="admin-header">
//         <button className="icon-btn" onClick={() => navigate("/")}>
//           <IoHomeOutline size={22} />
//         </button>

//         <h1 className="header-title">🌿 Herbal Admin Panel</h1>

//         <button className="icon-btn logout" onClick={handleLogout}>
//           <IoLogOutOutline size={22} />
//         </button>
//       </header>

//       {/* Sidebar */}
//       <aside className="sidebar">
//         <h2>Admin Panel</h2>
//         <ul>
//           <li>
//             <Link to="/admindashboard" className="sidebar-link">
//               <IoHomeOutline /> Dashboard
//             </Link>
//           </li>
//           <li>
//             <Link to="/admindashboard/manage-products" className="sidebar-link">
//               <IoSettingsOutline /> Manage Products
//             </Link>
//           </li>
//           <li>
//             <Link to="/admindashboard/user-list" className="sidebar-link">
//               <IoPeopleOutline /> User List
//             </Link>
//           </li>
//           <li>
//             <Link to="/admindashboard/orders" className="sidebar-link">
//               <IoCartOutline /> Orders
//             </Link>
//           </li>
//         </ul>
//       </aside>

//       {/* Page Content */}
//       <main className="main-content">
//         <Outlet />  
//       </main>

//       {/* Footer */}
//       <footer className="admin-footer">
//         <p>© {new Date().getFullYear()} Herbal Store Admin Dashboard</p>
//       </footer>
//     </div>
//   );
// }

// export default AdminDashboard;
import { Link, Outlet, useNavigate } from "react-router-dom";
import { IoLogOutOutline, IoHomeOutline, IoSettingsOutline, IoPeopleOutline, IoCartOutline } from "react-icons/io5";
import "./AdminDashboard.css";

function AdminDashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("adminToken");
    navigate("/");
  };

  return (
    <div className="admin-layout">

      {/* Header */}
      <header className="admin-header">
        <button className="icon-btn" onClick={() => navigate("/")}>
          <IoHomeOutline size={22} />
        </button>

        <h1 className="header-title">🌿 Herbal Admin Panel</h1>

        <button className="icon-btn logout" onClick={handleLogout}>
          <IoLogOutOutline size={22} />
        </button>
      </header>

      {/* Sidebar */}
      <aside className="sidebar">
        <h2>Admin Panel</h2>
        <ul>
          <li><Link to="/admindashboard" className="sidebar-link"><IoHomeOutline /> Dashboard</Link></li>
          <li><Link to="/admindashboard/manage-products" className="sidebar-link"><IoSettingsOutline /> Manage Products</Link></li>
          <li><Link to="/admindashboard/user-list" className="sidebar-link"><IoPeopleOutline /> User List</Link></li>
          <li><Link to="/admindashboard/orders" className="sidebar-link"><IoCartOutline /> Orders</Link></li>
        </ul>
      </aside>

      {/* Content */}
      <main className="main-content">
        <Outlet />
      </main>

      {/* Footer */}
      <footer className="admin-footer">
        <p>© {new Date().getFullYear()} Herbal Store Admin Dashboard</p>
      </footer>
    </div>
  );
}

export default AdminDashboard;
