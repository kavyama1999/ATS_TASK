// import React, { useEffect, useState } from "react";
// import api from "../api/axios";
// import "./Orders.css";

// const Orders = () => {
//   const [orders, setOrders] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     fetchOrders();
//   }, []);

//   const fetchOrders = async () => {
//     try {
//       const response = await api.get("/orders/");
//       setOrders(response.data);
//     } catch (error) {
//       console.error("Error fetching orders:", error);
//     } finally {
//       setLoading(false);
//     }
//   };

//   if (loading) {
//     return (
//       <div className="orders-loading">
//         <div className="spinner"></div>
//         <p>Fetching your herbal orders...</p>
//       </div>
//     );
//   }

//   return (
//     <div className="orders-page">
//       <div className="orders-header">
//         <h1>🌿 My Herbal Orders</h1>
//         <p>Track your eco-friendly purchases in one place</p>
//       </div>

//       {orders.length === 0 ? (
//         <div className="no-orders">
//           <p>😔 You haven’t placed any orders yet. Start shopping green 🌱</p>
//         </div>
//       ) : (
//         <div className="orders-grid">
//           {orders.map((order) => (
//             <div key={order.id} className="order-card">
//               <div className="order-top">
//                 <h2>Order #{order.id}</h2>
//                 <p className="order-date">
//                   {new Date(order.order_date).toLocaleString("en-IN", {
//                     year: "numeric",
//                     month: "short",
//                     day: "numeric",
//                     hour: "2-digit",
//                     minute: "2-digit",
//                     hour12: true,
//                   })}
//                 </p>
//               </div>

//               <div className="order-details">
//                 <p>
//                   👤 <strong>User:</strong> {order.username || "Unknown"}
//                 </p>
//                 <p>
//                   📧 <strong>Email:</strong> {order.email || "Not available"}
//                 </p>
//                 <p>
//                   💰 <strong>Total:</strong> ₹{order.total_price}
//                 </p>
//               </div>

//               <div className="order-footer">
//                 <span className="status success">✅ Order Confirmed</span>
//               </div>
//             </div>
//           ))}
//         </div>
//       )}
//     </div>
//   );
// };

// export default Orders;


// import React, { useEffect, useState } from "react";
// import api from "../api/axios";
// import "./Orders.css";

// const timeAgo = (dateString) => {
//   const date = new Date(dateString);
//   const seconds = Math.floor((new Date() - date) / 1000);

//   let interval = Math.floor(seconds / 31536000);
//   if (interval >= 1) return `${interval} year${interval > 1 ? "s" : ""} ago`;

//   interval = Math.floor(seconds / 2592000);
//   if (interval >= 1) return `${interval} month${interval > 1 ? "s" : ""} ago`;

//   interval = Math.floor(seconds / 86400);
//   if (interval >= 1) return `${interval} day${interval > 1 ? "s" : ""} ago`;

//   interval = Math.floor(seconds / 3600);
//   if (interval >= 1) return `${interval} hour${interval > 1 ? "s" : ""} ago`;

//   interval = Math.floor(seconds / 60);
//   if (interval >= 1) return `${interval} minute${interval > 1 ? "s" : ""} ago`;

//   return "just now";
// };

// const Orders = () => {
//   const [orders, setOrders] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     fetchOrders();
//     const interval = setInterval(fetchOrders, 15000); // auto-refresh
//     return () => clearInterval(interval);
//   }, []);

//   const fetchOrders = async () => {
//     try {
//       const response = await api.get("/orders/");
//       setOrders(response.data);
//     } catch (error) {
//       console.error("Error fetching orders:", error);
//     } finally {
//       setLoading(false);
//     }
//   };

//   if (loading) {
//     return (
//       <div className="orders-loading">
//         <div className="spinner"></div>
//         <p>Loading your orders...</p>
//       </div>
//     );
//   }

//   return (
//     <div className="orders-page">
//       <div className="orders-header">
//         <h1>🌿 My Orders</h1>
//         <p>Track your herbal product purchases in real-time</p>
//       </div>

//       {orders.length === 0 ? (
//         <div className="no-orders">
//           <p>😔 No orders yet. Place your first herbal order!</p>
//         </div>
//       ) : (
//         <div className="orders-grid">
//           {orders.map((order) => (
//             <div key={order.id} className="order-card">
//               <div className="order-top">
//                 <h2>Order #{order.id}</h2>
//                 <span className="order-time">{timeAgo(order.order_date)}</span>
//               </div>

//               <div className="order-details">
//                 <p>
//                   👤 <strong>{order.username || "Unknown User"}</strong>
//                 </p>
//                 <p>
//                   📧 {order.email || "No email available"}
//                 </p>
//                 <p>
//                   💰 Total: <strong>₹{order.total_price}</strong>
//                 </p>
//               </div>

//               <div className="order-footer">
//                 <span className="order-status">✅ Confirmed</span>
//               </div>
//             </div>
//           ))}
//         </div>
//       )}
//     </div>
//   );
// };

// export default Orders;


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
      <div className="orders-header">
        <h1>🌿 Users Orders</h1>
        {/* <p>Track all your herbal purchases in real-time</p> */}
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
  );
};

export default Orders;
