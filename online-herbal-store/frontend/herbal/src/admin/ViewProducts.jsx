// function ViewProducts() {
//   return (
//     <div>
//       <h1>All Products</h1>
//       <p>Here products will be displayed.</p>
//     </div>
//   );
// }

// export default ViewProducts;


import Products from "../components/Products";  // ✅ using your existing products UI
import { Link } from "react-router-dom";
import "./AdminDashboard.css"; // ✅ same layout styling

function ViewProducts() {
  return (
    <div className="admin-layout">

    

      {/* Right Main Content */}
      <main className="main-content">
        <h1>View Products</h1>
        <Products /> {/* ✅ Display your existing Products page here */}
      </main>

    </div>
  );
}

export default ViewProducts;
