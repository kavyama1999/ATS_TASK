
import { Routes, Route, useLocation, Link } from "react-router-dom";
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

import RegisterUser from "./users/RegisterUser";
import UserLogin from "./users/UserLogin";
import UserList from "./users/UserList";

import Orders from "./orders/Orders";
import Cart from "./orders/Cart";
import Checkout from "./orders/Checkout";
import OrderSuccess from "./orders/OrderSuccess";



function App() {
  const location = useLocation();

  // ✅ Hide Navbar & Footer when admin dashboard pages are active
  const hideLayout = location.pathname.startsWith("/admindashboard");

  return (
    <>
      {!hideLayout && <Navbar />}

      {/* <h2 className="text-3xl text-green-700 text-center font-bold mt-4">
        🌿 Kavya Herbal Store 🌿
      </h2> */}

      <Routes>
        {/* 🌸 Public Routes */}
        <Route path="/" element={<Products />} />
        <Route path="/products" element={<Products />} />
        <Route path="/about" element={<About />} />

        {/* 🧑‍💼 Admin Login */}
        <Route path="/adminlogin" element={<AdminLogin />} />

        {/* 🧩 Admin Dashboard Layout */}
        <Route path="/admindashboard" element={<AdminDashboard />}>
          <Route path="view-products" element={<ViewProducts />} />
          <Route path="add-product" element={<AddProduct />} />
          <Route path="admin-view-products" element={<AdminViewProducts />} />
          <Route path="manage-products" element={<ManageProducts />} />
          <Route path="user-list" element={<UserList />} /> 
            <Route path="orders" element={<Orders />} />



        </Route>

        {/* 👤 User Management */}
        <Route path="/register" element={<RegisterUser />} />
        <Route path="/users" element={<UserList />} />
        <Route path="/user-login" element={<UserLogin />} />

        {/* 🛒 Orders */}
        <Route path="/orders" element={<Orders />} />
        <Route path="/orders/cart" element={<Cart />} />
        <Route path="/orders/checkout" element={<Checkout />} />
        <Route path="/orders/ordersuccess" element={<OrderSuccess />} />
      </Routes>


      {!hideLayout && <Footer />}
    </>
  );
}

export default App;
