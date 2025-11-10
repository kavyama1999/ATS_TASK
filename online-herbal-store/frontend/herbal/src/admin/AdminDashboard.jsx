// import { Link } from "react-router-dom";

// const AdminDashboard = () => {
//   return (
//     <div style={{ padding: "40px", textAlign: "center" }}>
//       <h1>Welcome to Admin Dashboard 🌿</h1>
//       <p>Manage your products efficiently here.</p>

//       <div style={{ marginTop: "30px" }}>
//         <Link to="/manageproducts">
//           <button
//             style={{
//               backgroundColor: "#2e7d32",
//               color: "white",
//               border: "none",
//               padding: "12px 25px",
//               borderRadius: "8px",
//               cursor: "pointer",
//               fontSize: "16px",
//             }}
//           >
//             Manage Products
//           </button>
//         </Link>
//       </div>
//     </div>
//   );
// };

// export default AdminDashboard;


import { Link, Outlet } from "react-router-dom";
import "./AdminDashboard.css";

function AdminDashboard() {
  return (
    <div className="admin-layout">

      <aside className="sidebar">
        <h2>Admin Panel</h2>
        <ul>
         <li><Link to="/admindashboard/view-products">View Products</Link></li>
          <li><Link to="/admindashboard/add-product">Add Product</Link></li>
        </ul>
      </aside>

      <main className="main-content">
        <Outlet /> 
      </main>

    </div>
  );
}

export default AdminDashboard;
