// // function ViewProducts() {
// //   return (
// //     <div>
// //       <h1>All Products</h1>
// //       <p>Here products will be displayed.</p>
// //     </div>
// //   );
// // }

// // export default ViewProducts;


// import Products from "../components/Products";  // ✅ using your existing products UI
// import { Link } from "react-router-dom";
// import "./AdminDashboard.css"; // ✅ same layout styling

// function ViewProducts() {
//   return (
//     <div className="admin-layout">

    

//       {/* Right Main Content */}
//       <main className="main-content">
//         <h1>View Products</h1>
//         <Products /> {/* ✅ Display your existing Products page here */}
//       </main>

//     </div>
//   );
// }

// export default ViewProducts;


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
        <div className="header-left">
          {/* 🌿 Home Button */}
          <button onClick={() => navigate("/")} className="home-btn">
            🏠
          </button>

          <h1>🌿 Herbal Admin Panel</h1>
        </div>

        {/* 🌿 Logout Button */}
        <button onClick={handleLogout} className="logout-btn">
          <IoLogOutOutline className="logout-icon" />
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
