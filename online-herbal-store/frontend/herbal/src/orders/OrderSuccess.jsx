// import React from "react";
// import { useNavigate } from "react-router-dom";

// const OrderSuccess = () => {
//   const navigate = useNavigate();

//   return (
//     <div className="flex flex-col items-center justify-center min-h-screen bg-green-50">
//       <h1 className="text-4xl text-green-700 font-bold mb-4">
//         🎉 Order Placed Successfully!
//       </h1>
//       <p className="text-lg text-gray-700 mb-6">
//         Thank you for shopping with us. Your order will be delivered soon.
//       </p>
//       <button
//         onClick={() => navigate("/")}
//         className="bg-green-700 text-white px-4 py-2 rounded-lg hover:bg-green-800"
//       >
//         Back to Home
//       </button>
//     </div>
//   );
// };

// export default OrderSuccess;

import React from "react";
import { useNavigate } from "react-router-dom";
import "./OrderSuccess.css";

const OrderSuccess = () => {
  const navigate = useNavigate();

  return (
    <div className="order-success-container">
      <div className="order-success-card">
        {/* ✅ Success Circle with Animated Checkmark */}
        <div className="success-circle">
          <div className="checkmark">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 52 52"
              className="checkmark-svg"
            >
              <circle
                className="checkmark-circle"
                cx="26"
                cy="26"
                r="25"
                fill="none"
              />
              <path
                className="checkmark-check"
                fill="none"
                d="M14 27l7 7 16-16"
              />
            </svg>
          </div>
        </div>

        {/* Title & Message */}
        <h1 className="success-title">Order Confirmed!</h1>
        <p className="success-message">
          🎉 Thank you for shopping with <span>Herbal Bliss</span> 🌿
          <br />
          Your order has been successfully placed and will be delivered soon.
        </p>

        {/* Divider */}
        <div className="divider"></div>

        {/* Order Summary */}
        <div className="order-summary">
          <h3>✅ Payment Received</h3>
          <p>Your order details have been sent to your registered email.</p>
        </div>

        {/* Back Button */}
        <button className="home-btn" onClick={() => navigate("/")}>
          🏠 Back to Home
        </button>
      </div>
    </div>
  );
};

export default OrderSuccess;
