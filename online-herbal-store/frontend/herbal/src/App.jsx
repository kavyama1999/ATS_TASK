// import { Routes, Route } from "react-router-dom";
// import Navbar from "./components/Navbar";
// import Footer from "./components/Footer";
// import Products from "./components/Products";
// import About from "./components/About";

// import AdminLogin from "./admin/AdminLogin";
// import AdminDashboard from "./admin/AdminDashboard";
// import ManageProducts from "./admin/ManageProducts";
// import ViewProducts from "./admin/ViewProducts";
// import AddProduct from "./admin/AddProduct";


// function App() {
//   return (
//     <>
//       <Navbar />
//       <Routes>
//         {/* Public */}
//         <Route path="/" element={<Products />} />
//         <Route path="/products" element={<Products />} />
//         <Route path="/about" element={<About />} />

//         {/* Admin Login */}
//         <Route path="/adminlogin" element={<AdminLogin />} />

//         {/* Admin Dashboard with nested routing */}
//         <Route path="/admindashboard" element={<AdminDashboard />}>
//           <Route path="view-products" element={<ViewProducts />} />
//           <Route path="/admindashboard/add-product" element={<AddProduct />} />

//         </Route>

//       </Routes>
//       <Footer />
//     </>
//   );
// }

// export default App;
import { Routes, Route, useLocation } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Products from "./components/Products";
import About from "./components/About";

import AdminLogin from "./admin/AdminLogin";
import AdminDashboard from "./admin/AdminDashboard";
import ManageProducts from "./admin/ManageProducts";
import ViewProducts from "./admin/ViewProducts";
import AddProduct from "./admin/AddProduct";
import AdminViewProducts from "./admin/AdminViewProducts";


function App() {

  const location = useLocation();

  // ✅ Hide Navbar & Footer when admin dashboard pages are active
  const hideLayout = location.pathname.startsWith("/admindashboard");

  return (
    <>
      {!hideLayout && <Navbar />}
{/* <h2 className="text-4xl font-bold text-green-600 text-center mt-600">
  🌿 Kavya Herbal 🌿
</h2> */}
<h2 className="text-4xl text-green-600 text-center">Tailwind Test</h2>

      <Routes>
        {/* Public */}
        <Route path="/" element={<Products />} />
        <Route path="/products" element={<Products />} />
        <Route path="/about" element={<About />} />

        {/* Admin Login */}
        <Route path="/adminlogin" element={<AdminLogin />} />

        {/* ✅ Admin Dashboard Layout */}
        <Route path="/admindashboard" element={<AdminDashboard />}>
          
          {/* ✅ Correct nested paths (remove /admindashboard/ prefix) */}
          <Route path="view-products" element={<ViewProducts />} />
          <Route path="add-product" element={<AddProduct />} />
          <Route path="admin-view-products" element={<AdminViewProducts />} />
          <Route path="manage-products" element={<ManageProducts />} />


          
        </Route>
      </Routes>

      {!hideLayout && <Footer />}
    </>
  );
}

export default App;
