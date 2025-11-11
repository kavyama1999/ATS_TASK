
// import { Link, Outlet } from "react-router-dom";
// import "./AdminDashboard.css";


// function AdminDashboard() {
//   return (
//     <div className="admin-layout">

//       <aside className="sidebar">
//         <h2>Admin Panel</h2>
//         <ul>
//          <li><Link to="/admindashboard/view-products">View Products</Link></li>
//          <li><Link to="/admindashboard/admin-view-products">View Products</Link></li>

//           <li><Link to="/admindashboard/add-product">Add Product</Link></li>
//         </ul>
//       </aside>

//       <main className="main-content">
//         <Outlet /> 
//       </main>

//     </div>
//   );
// }

// export default AdminDashboard;

import { Link, Outlet, useNavigate } from "react-router-dom";
import { IoLogOutOutline } from "react-icons/io5"; // logout icon
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
        <h1>🌿 Herbal Admin Panel</h1>



        <button onClick={handleLogout} className="logout-btn">
  <IoLogOutOutline size={30} className="logout-icon" />
</button>

      </header>

      {/* 🌿 Sidebar */}
      <aside className="sidebar">
        <h2>Dashboard</h2>
        <ul>
          <li><Link to="/admindashboard/admin-view-products">View Products</Link></li>
          <li><Link to="/admindashboard/add-product">Add Product</Link></li>
          <li>
            <Link to="/admindashboard/manage-products">⚙️ Manage Products</Link>
          </li>
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
