

// import { Link, Outlet, useNavigate } from "react-router-dom";
// import { IoLogOutOutline } from "react-icons/io5"; // logout icon
// import "./AdminDashboard.css";

// function AdminDashboard() {
//   const navigate = useNavigate();

//   const handleLogout = () => {
//     localStorage.removeItem("adminToken");
//     navigate("/"); // go to home page
//   };

//   return (
//     <div className="admin-layout">
//       {/* 🌿 Header */}
//       <header className="admin-header">
//         <h1>🌿 Herbal Admin Panel</h1>



//         <button onClick={handleLogout} className="logout-btn">
//   <IoLogOutOutline size={30} className="logout-icon" />
// </button>

//       </header>

//       {/* 🌿 Sidebar */}
//       <aside className="sidebar">
//         <h2>Dashboard</h2>
//         <ul>
//           <li><Link to="/admindashboard/admin-view-products">View Products</Link></li>
//           <li><Link to="/admindashboard/add-product">Add Product</Link></li>
//           <li>
//             <Link to="/admindashboard/manage-products">⚙️ Manage Products</Link>
//           </li>
//             <li>
//        <Link to="/admindashboard/user-list">User List</Link>
//           </li>
//           <li>
//             <Link to="/admindashboard/orders">🛒 Orders</Link> {/* ✅ New Orders link */}
//           </li>
//         </ul>
//       </aside>

//       {/* 🌿 Main Content */}
//       <main className="main-content">
//         <Outlet />
//       </main>

//       {/* 🌿 Footer */}
//       <footer className="admin-footer">
//         <p>© {new Date().getFullYear()} Herbal Store Admin Dashboard</p>
//       </footer>
//     </div>
//   );
// }

// export default AdminDashboard;



import { Link, Outlet, useNavigate } from "react-router-dom";
import { IoLogOutOutline, IoHomeOutline } from "react-icons/io5"; // logout & home icons

import "./AdminDashboard.css";

function AdminDashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("adminToken");
    navigate("/"); // go to home page
  };

  return (
    <div className="admin-layout">
      {/* 🌿 Header */}
      <header className="admin-header">
        {/* Home button on the left */}
        <Link to="/" className="home-btn">
          <IoHomeOutline size={24} />
        </Link>

        {/* Centered title */}
        <h1>🌿 Herbal Admin Panel</h1>

        {/* Logout button on the right */}
        <button onClick={handleLogout} className="logout-btn">
          <IoLogOutOutline size={24} />
        </button>
      </header>

      {/* 🌿 Sidebar */}
      <aside className="sidebar">
        <h2>Dashboard</h2>
        <ul>
          <li><Link to="/admindashboard/admin-view-products">View Products</Link></li>
          <li><Link to="/admindashboard/add-product">Add Product</Link></li>
          <li><Link to="/admindashboard/manage-products">⚙️ Manage Products</Link></li>
          <li><Link to="/admindashboard/user-list">User List</Link></li>
          <li><Link to="/admindashboard/orders">🛒 Orders</Link></li>
        </ul>
      </aside>

      {/* 🌿 Main Content */}
      <main className="main-content">
        <Outlet />
      </main>

      {/* 🌿 Footer */}
      <footer className="admin-footer">
        <p>© {new Date().getFullYear()} Herbal Store Admin Dashboard</p>
      </footer>
    </div>
  );
}

export default AdminDashboard;
