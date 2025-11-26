
import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./OrderSuccess.css";

const OrderSuccess = () => {
  const navigate = useNavigate();
  const { state } = useLocation();
  const orderId = state?.orderId;

  if (!orderId) {
    return (
      <div style={{ textAlign: "center", padding: "50px" }}>
        <h2>No order found!</h2>
        <button onClick={() => navigate("/products")}>Go back to Products</button>
      </div>
    );
  }

  return (
    <div className="order-success-container">
      <div className="order-success-card">
        <div className="success-circle">
          <div className="checkmark">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52" className="checkmark-svg">
              <circle className="checkmark-circle" cx="26" cy="26" r="25" fill="none" />
              <path className="checkmark-check" fill="none" d="M14 27l7 7 16-16" />
            </svg>
          </div>
        </div>

        <h1 className="success-title">Order Confirmed!</h1>
        <p className="success-message">
          🎉 Thank you for shopping with <span>Herbal Bliss</span> 🌿
          <br />
          Your Order ID is <strong>{orderId}</strong> and it will be delivered soon.
        </p>
        <button className="home-btn" onClick={() => navigate("/products")}>
          🏠 Back to Home
        </button>
      </div>
    </div>
  );
};

export default OrderSuccess;
