
import { Link, Outlet, useNavigate } from "react-router-dom";
import { IoLogOutOutline, IoHomeOutline } from "react-icons/io5";

import "./AdminDashboard.css";

function AdminDashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("adminToken");
    navigate("/");
  };

  return (
    <div className="admin-layout">

      {/* 🌿 Header */}
      <header className="admin-header">

        {/* Home Button */}
        <button className="icon-btn" onClick={() => navigate("/")}>
          <IoHomeOutline size={22} />
        </button>

        {/* Center Title */}
        <h1 className="header-title">🌿 Herbal Admin Panel</h1>

        {/* Logout Button */}
        <button className="icon-btn logout" onClick={handleLogout}>
          <IoLogOutOutline size={22} />
        </button>
      </header>

      {/* Sidebar */}
      <aside className="sidebar">
        <h2>Dashboard</h2>
        <ul>
          {/* <li><Link to="/admindashboard/admin-view-products">View Products</Link></li> */}
          {/* <li><Link to="/admindashboard/add-product">Add Product</Link></li> */}
          <li><Link to="/admindashboard/manage-products">⚙️ Manage Products</Link></li>
          <li><Link to="/admindashboard/user-list">User List</Link></li>
          <li><Link to="/admindashboard/orders">🛒 Orders</Link></li>
        </ul>
      </aside>

      {/* Main Content */}
      <main className="main-content">


        {/* 🌿 Herbal Animation Section */}
        <div className="dashboard-hero">
          <h2 className="herbal-title">Welcome to Herbal Admin Dashboard 🌿</h2>

          <div className="animation-box small">
            <img src="/leaf.png" className="leaf" style={{ left: "10%" }} />
            <img src="/leaf.png" className="leaf" style={{ left: "30%", animationDelay: "1.5s" }} />
            <img src="/leaf.png" className="leaf" style={{ left: "50%", animationDelay: "3s" }} />
            <img src="/leaf.png" className="leaf" style={{ left: "70%", animationDelay: "2s" }} />
            <img src="/leaf.png" className="leaf" style={{ left: "85%", animationDelay: "4s" }} />
          </div>
        </div>


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
