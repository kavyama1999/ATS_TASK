
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
import DashboardHome from "./admin/DashboardHome";


import RegisterUser from "./users/RegisterUser";
import UserLogin from "./users/UserLogin";
import UserList from "./users/UserList";
import UserDashboard from "./users/UserDashboard";
import UserProfile from "./users/UserProfile";
import EditProfile from "./users/EditProfile";

import ForgotPassword from "./users/ForgotPassword";
import VerifyOTP from "./users/VerifyOTP";
import ResetPassword from "./users/ResetPassword";




import Orders from "./orders/Orders";
import Cart from "./orders/Cart";
import Checkout from "./orders/Checkout";
import OrderSuccess from "./orders/OrderSuccess";
import Payment from "./orders/Payment";
//import Payment from "./orders/MyOrders";
import MyOrders from "./orders/MyOrders";






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

           {/* ✅ Dashboard Home (Welcome + Stats) */}
          <Route index element={<DashboardHome />} />
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
        <Route path="/dashboard" element={<UserDashboard />} />
        <Route path="/user-profile" element={<UserProfile />} />
        <Route path="/edit-profile" element={<EditProfile />} />

        <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/verify-otp" element={<VerifyOTP />} />
        <Route path="/reset-password" element={<ResetPassword />} />





        {/* 🛒 Orders */}
        <Route path="/orders" element={<Orders />} />
        <Route path="/orders/cart" element={<Cart />} />
        <Route path="/orders/checkout" element={<Checkout />} />
        <Route path="/orders/payment" element={<Payment />} />
        <Route path="/orders/ordersuccess" element={<OrderSuccess />} />
        <Route path="/orders/myorders" element={<MyOrders/>} />

      </Routes>


      {!hideLayout && <Footer />}
    </>
  );
}

export default App;
