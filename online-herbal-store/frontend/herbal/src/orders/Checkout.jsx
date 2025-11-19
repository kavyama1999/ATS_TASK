

// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./Checkout.css";

// const Checkout = () => {
//   const navigate = useNavigate();
//   const [items, setItems] = useState([]);
//   const [total, setTotal] = useState(0);

//   useEffect(() => {
//     const saved = JSON.parse(localStorage.getItem("cartCheckout"));
//     const single = JSON.parse(localStorage.getItem("checkoutItem"));

//     if (saved) setItems(saved);
//     else if (single) setItems([single]);
//     else navigate("/products");
//   }, []);

//   useEffect(() => {
//     setTotal(items.reduce((s, i) => s + i.price * i.quantity, 0));
//   }, [items]);

//   const changeQty = (id, delta) => {
//     setItems((prev) =>
//       prev.map((i) =>
//         i.id === id ? { ...i, quantity: Math.max(1, i.quantity + delta) } : i
//       )
//     );
//   };

//   const placeOrder = async () => {
//     const user_id = localStorage.getItem("user_id");
//     if (!user_id) return navigate("/user-login");

//     const payload = {
//       user_id: parseInt(user_id),
//       total_price: total,
//       items: items.map((i) => ({
//         product_id: i.id,
//         quantity: i.quantity,
//         price: i.price,
//       })),
//     };

//     const res = await api.post("/orders/", payload);

//     // FIX 1: ❗ DO NOT CLEAR ALL LOCALSTORAGE ❗
//     // localStorage.clear();  <-- removed

//     // FIX 2: remove ONLY checkout temp data
//     localStorage.removeItem("cartCheckout");
//     localStorage.removeItem("checkoutItem");

//     // cart should remain 😎
//     // user_id should remain 😎

//     // FIX 3: Correct navigation
//     navigate("/orders/ordersuccess", { state: { orderId: res.data.id } });
//   };

//   return (
//     <div className="checkout-page">
//       <div className="checkout-box">
//         <h2>Checkout</h2>

//         {items.map((p) => (
//           <div key={p.id} className="checkout-card">
//             <img src={p.image_url} className="chk-img" />

//             <div className="chk-info">
//               <h3>{p.name}</h3>
//               <p>Price: ₹{p.price}</p>

//               <div className="chk-qty">
//                 <button onClick={() => changeQty(p.id, -1)}>-</button>
//                 <span>{p.quantity}</span>
//                 <button onClick={() => changeQty(p.id, 1)}>+</button>
//               </div>

//               <p>Subtotal: ₹{p.price * p.quantity}</p>
//             </div>
//           </div>
//         ))}

//         <div className="summary">
//           <h3>Total Amount: ₹{total}</h3>
//           <button onClick={placeOrder} className="order-btn">
//             Pay Now & Place Order
//           </button>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Checkout;


import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";
import "./Checkout.css";

const Checkout = () => {
  const navigate = useNavigate();
  const [items, setItems] = useState([]);
  const [total, setTotal] = useState(0);
  const [loading, setLoading] = useState(false); // ⭐ NEW

  useEffect(() => {
    const saved = JSON.parse(localStorage.getItem("cartCheckout"));
    const single = JSON.parse(localStorage.getItem("checkoutItem"));

    if (saved) setItems(saved);
    else if (single) setItems([single]);
    else navigate("/products");
  }, []);

  useEffect(() => {
    setTotal(items.reduce((s, i) => s + i.price * i.quantity, 0));
  }, [items]);

  const changeQty = (id, delta) => {
    setItems((prev) =>
      prev.map((i) =>
        i.id === id ? { ...i, quantity: Math.max(1, i.quantity + delta) } : i
      )
    );
  };

  const placeOrder = async () => {
    const user_id = localStorage.getItem("user_id");
    if (!user_id) return navigate("/user-login");

    setLoading(true); // ⭐ SHOW LOADING

    const payload = {
      user_id: parseInt(user_id),
      total_price: total,
      items: items.map((i) => ({
        product_id: i.id,
        quantity: i.quantity,
        price: i.price,
      })),
    };

    try {
      const res = await api.post("/orders/", payload);

      localStorage.removeItem("cartCheckout");
      localStorage.removeItem("checkoutItem");

      navigate("/orders/ordersuccess", { state: { orderId: res.data.id } });
    } catch (err) {
      console.error(err);
    } finally {
      setLoading(false); // ⭐ HIDE LOADING
    }
  };

  return (
    <div className="checkout-page">
      {/* ⭐ LOADING OVERLAY */}
      {loading && (
        <div className="loading-overlay">
          <div className="loader"></div>
          <p>Processing your order...</p>
        </div>
      )}

      <div className={`checkout-box ${loading ? "blurred" : ""}`}>
        <h2>Checkout</h2>

        {items.map((p) => (
          <div key={p.id} className="checkout-card">
            <img src={p.image_url} className="chk-img" />

            <div className="chk-info">
              <h3>{p.name}</h3>
              <p>Price: ₹{p.price}</p>

              <div className="chk-qty">
                <button onClick={() => changeQty(p.id, -1)} disabled={loading}>
                  -
                </button>
                <span>{p.quantity}</span>
                <button onClick={() => changeQty(p.id, 1)} disabled={loading}>
                  +
                </button>
              </div>

              <p>Subtotal: ₹{p.price * p.quantity}</p>
            </div>
          </div>
        ))}

        <div className="summary">
          <h3>Total Amount: ₹{total}</h3>
          <button
            onClick={placeOrder}
            className="order-btn"
            disabled={loading}
          >
            {loading ? "Processing..." : "Pay Now & Place Order"}
          </button>
        </div>
      </div>
    </div>
  );
};

export default Checkout;
