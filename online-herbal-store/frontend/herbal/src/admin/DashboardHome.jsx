import React, { useEffect, useState } from "react";
import { IoSettingsOutline, IoPeopleOutline, IoCartOutline } from "react-icons/io5";
import api from "../api/axios";

function DashboardHome() {

  const [usersCount, setUsersCount] = useState(0);
  const [productsCount, setProductsCount] = useState(0);
  const [ordersCount, setOrdersCount] = useState(0);

  useEffect(() => {
    fetchUsers();
    fetchProducts();
    fetchOrders();
  }, []);

  const fetchUsers = async () => {
    const res = await api.get("/users/");
    setUsersCount(res.data.length);
  };

  const fetchProducts = async () => {
    const res = await api.get("/products/");
    setProductsCount(res.data.length);
  };

  const fetchOrders = async () => {
    const res = await api.get("/orders/");
    setOrdersCount(res.data.length);
  };

  return (
    <>
      {/* Welcome */}

      <div className="herbal-welcome-box">
        {/* <h2>🌿 Welcome Admin</h2> */}
        <h2>Here is today’s quick overview of herbal store performance.</h2>
      </div>

      {/* Stats */}
      <div className="herbal-stats">

        <div className="herbal-card">
          <IoPeopleOutline className="h-icon users" />
          <h3>Total Users</h3>
          <div className="h-number">{usersCount}</div>
        </div>

        <div className="herbal-card">
          <IoSettingsOutline className="h-icon products" />
          <h3>Total Products</h3>
          <div className="h-number">{productsCount}</div>
        </div>

        <div className="herbal-card">
          <IoCartOutline className="h-icon orders" />
          <h3>Total Orders</h3>
          <div className="h-number">{ordersCount}</div>
        </div>

      </div>
    </>
  );
}

export default DashboardHome;
