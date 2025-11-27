
//latest order should come first

import React, { useEffect, useState } from "react";
import api from "../api/axios";
import "./Orders.css";

const formatDateTime = (dateString) => {
  const date = new Date(dateString);
  return date.toLocaleString("en-IN", {
    day: "2-digit",
    month: "short",
    year: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    hour12: true,
  });
};

const Orders = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchOrders();
    const interval = setInterval(fetchOrders, 15000); // auto-refresh every 15s
    return () => clearInterval(interval);
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await api.get("/orders/");

      // ✅ Sort: latest order on top
      const sortedOrders = response.data.sort(
        (a, b) => new Date(b.order_date) - new Date(a.order_date)
      );

      setOrders(sortedOrders);
    } catch (error) {
      console.error("Error fetching orders:", error);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="orders-loading">
        <div className="spinner"></div>
        <p>Loading your orders...</p>
      </div>
    );
  }

  return (
    <div>
    <div className="orders-page">
      <div className="orders-header">
        <h1>🌿 Users Orders</h1>
      </div>

      {orders.length === 0 ? (
        <div className="no-orders">
          <p>😔 You haven’t placed any orders yet.</p>
        </div>
      ) : (
        <div className="orders-grid">
          {orders.map((order) => (
            <div key={order.id} className="order-card">
              <div className="order-top">
                <h2>Order #{order.id}</h2>
                <span className="order-time">
                  {formatDateTime(order.order_date)}
                </span>
              </div>

              <div className="order-details">
                <p>
                  👤 <strong>{order.username || "Unknown User"}</strong>
                </p>
                <p>📧 {order.email || "Not available"}</p>
                <p>
                  💰 Total: <strong>₹{order.total_price}</strong>
                </p>
              </div>

              <div className="order-footer">
                <span className="order-status">✅ Confirmed</span>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
    </div>
  );
};

export default Orders;
