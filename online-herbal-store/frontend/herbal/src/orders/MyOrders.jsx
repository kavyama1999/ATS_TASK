

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

const MyOrders = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const userId = localStorage.getItem("user_id");

  useEffect(() => {
    fetchMyOrders();
  }, []);

  const fetchMyOrders = async () => {
    try {
      const response = await api.get(`/orders/user/${userId}/`);
      setOrders(response.data);
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
    <div className="orders-page">
      <h1 className="orders-title">📦 My Orders</h1>

      {orders.length === 0 ? (
        <div className="no-orders">
          <p>You haven't placed any orders yet.</p>
        </div>
      ) : (
        <div className="orders-grid">
          {orders.map((order) => (
            <div key={order.id} className="order-card">

              {/* Top Section */}
              <div className="order-top">
                <h2 className="order-id">Order #{order.id}</h2>
                <span className="order-date">{formatDateTime(order.order_date)}</span>
              </div>

              {/* Order Details */}
              <p className="order-total">💰 Total: ₹{order.total_price}</p>
              <p className="order-address">📍 Address: {order.address}</p>

              {/* Product Items */}
              <div className="order-items">
                {order.items.map((item) => (
                  <div key={item.id} className="item-card">
                    <img
                      src={item.image_url}
                      alt={item.product_name}
                      className="item-image"
                    />

                    <div className="item-info">
                      <h4 className="item-name">{item.product_name}</h4>
                      <p>Qty: {item.quantity}</p>
                      <p>Price: ₹{item.price}</p>
                    </div>
                  </div>
                ))}
              </div>

              <div className="order-footer">
                <span className="order-status">✅ Confirmed</span>
              </div>

            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default MyOrders;
