


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

//   const [usersCount, setUsersCount] = useState(0);
//   const [productsCount, setProductsCount] = useState(0);
//   const [ordersCount, setOrdersCount] = useState(0);

//   // === Fetch Users Count ===
//   const fetchUsers = async () => {
//     try {
//       const res = await api.get("/users/");
//       setUsersCount(res.data.length);
//     } catch (err) {
//       console.error("Error fetching users:", err);
//     }
//   };

//   // === Fetch Products Count ===
//   const fetchProducts = async () => {
//     try {
//       const res = await api.get("/products/");
//       setProductsCount(res.data.length);
//     } catch (err) {
//       console.error("Error fetching products:", err);
//     }
//   };

//   // === Fetch Orders Count ===
//   const fetchOrders = async () => {
//     try {
//       const res = await api.get("/orders/");
//       setOrdersCount(res.data.length);
//     } catch (err) {
//       console.error("Error fetching orders:", err);
//     }
//   };

//   // useEffect(() => {
//   //   fetchUsers();
//   //   fetchProducts();
//   //   fetchOrders();
//   // }, []);


//   useEffect(() => {
//   // Initial load
//   fetchUsers();
//   fetchProducts();
//   fetchOrders();

//   // Refresh every 10 seconds
//   const interval = setInterval(() => {
//     fetchUsers();
//     fetchProducts();
//     fetchOrders();
//   }, 10000);

//   return () => clearInterval(interval);
// }, []);


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
//         <h2>Dashboard</h2>
//         <ul>
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

//       {/* Main Content */}
//       <main className="main-content">

//         {/* Welcome Box */}
//         <div className="herbal-welcome-box">
//           <h2>🌿 Welcome</h2>
//           <p>Here is today’s quick overview of your herbal store performance.</p>
//         </div>

//         {/* Stats Section */}
//         <div className="herbal-stats">

//           {/* Users Card */}
//           <div className="herbal-card">
//             <IoPeopleOutline className="h-icon users" />
//             <h3>Total Users</h3>
//             <div className="h-number">{usersCount}</div>
//           </div>

//           {/* Products Card */}
//           <div className="herbal-card">
//             <IoSettingsOutline className="h-icon products" />
//             <h3>Total Products</h3>
//             <div className="h-number">{productsCount}</div>
//           </div>

//           {/* Orders Card */}
//           <div className="herbal-card">
//             <IoCartOutline className="h-icon orders" />
//             <h3>Total Orders</h3>
//             <div className="h-number">{ordersCount}</div>
//           </div>

//         </div>

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
import { useEffect, useState } from "react";
import {
  IoLogOutOutline,
  IoHomeOutline,
  IoSettingsOutline,
  IoPeopleOutline,
  IoCartOutline
} from "react-icons/io5";

import api from "../api/axios";
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
          <li>
            <Link to="/admindashboard" className="sidebar-link">
              <IoHomeOutline /> Dashboard
            </Link>
          </li>
          <li>
            <Link to="/admindashboard/manage-products" className="sidebar-link">
              <IoSettingsOutline /> Manage Products
            </Link>
          </li>
          <li>
            <Link to="/admindashboard/user-list" className="sidebar-link">
              <IoPeopleOutline /> User List
            </Link>
          </li>
          <li>
            <Link to="/admindashboard/orders" className="sidebar-link">
              <IoCartOutline /> Orders
            </Link>
          </li>
        </ul>
      </aside>

      {/* Page Content */}
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
