


// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./Checkout.css";

// const Checkout = () => {
//   const navigate = useNavigate();
//   const [items, setItems] = useState([]);
//   const [total, setTotal] = useState(0);
//   const [loading, setLoading] = useState(false); // ⭐ NEW

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

//     setLoading(true); // ⭐ Start blur

//     const payload = {
//       user_id: parseInt(user_id),
//       total_price: total,
//       items: items.map((i) => ({
//         product_id: i.id,
//         quantity: i.quantity,
//         price: i.price,
//       })),
//     };

//     try {
//       const res = await api.post("/orders/", payload);

//       localStorage.removeItem("cartCheckout");
//       localStorage.removeItem("checkoutItem");

//       navigate("/orders/ordersuccess", { state: { orderId: res.data.id } });
//     } catch (err) {
//       console.error(err);
//     } finally {
//       setLoading(false); // ⭐ Remove blur if needed
//     }
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

//           {/* ⭐ BUTTON WITH LOADING & BLUR */}
//           <button
//             onClick={placeOrder}
//             className="order-btn"
//             disabled={loading}
//           >
//             {loading ? "Processing..." : "Pay Now & Place Order"}
//           </button>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Checkout;


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
//     setItems(prev =>
//       prev.map(i =>
//         i.id === id ? { ...i, quantity: Math.max(1, i.quantity + delta) } : i
//       )
//     );
//   };

//   // ⭐ Proceed to Payment
//   const proceedToPayment = () => {
//     const user_id = localStorage.getItem("user_id");
//     if (!user_id) {
//       alert("Please login first");
//       return navigate("/user-login");
//     }

//     const orderData = {
//       user_id: parseInt(user_id),
//       total_price: total,      // ⭐ Correct key
//       items: items.map(i => ({
//         product_id: i.id,
//         quantity: i.quantity,
//         price: i.price,
//       })),
//     };

//     navigate("/orders/payment", { state: { orderData } });
//   };

//   return (
//     <div className="checkout-page">
//       <div className="checkout-box">
//         <h2>Checkout</h2>

//         {items.map(p => (
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

//           <button className="order-btn" onClick={proceedToPayment}>
//             Proceed to Pay
//           </button>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Checkout;


//today

// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./Checkout.css";

// const Checkout = () => {
//   const navigate = useNavigate();
//   const [items, setItems] = useState([]);
//   const [total, setTotal] = useState(0);

//   useEffect(() => {
//     const single = JSON.parse(localStorage.getItem("checkoutItem"));
//     const saved = JSON.parse(localStorage.getItem("cartCheckout"));

//     if (single) {
//       setItems([single]);   // ⭐ Buy Now priority
//     } else if (saved) {
//       setItems(saved);
//     } else {
//       navigate("/products");
//     }
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

//   const proceedToPayment = () => {
//     const user_id = localStorage.getItem("user_id");

//     if (!user_id) {
//       alert("Please login first");
//       return navigate("/user-login");
//     }

//     const orderData = {
//       user_id: parseInt(user_id),
//       total_price: total,
//       items: items.map((i) => ({
//         product_id: i.id,
//         quantity: i.quantity,
//         price: i.price,
//       })),
//     };

//     navigate("/orders/payment", { state: { orderData } });
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

//           <button className="order-btn" onClick={proceedToPayment}>
//             Proceed to Pay
//           </button>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Checkout;


// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./Checkout.css";

// const Checkout = () => {
//   const navigate = useNavigate();
//   const [items, setItems] = useState([]);

//   useEffect(() => {
//     const userId = localStorage.getItem("user_id");

//     const single = JSON.parse(localStorage.getItem("checkoutItem"));
//     const cartItems = JSON.parse(localStorage.getItem(`cartCheckout_${userId}`));

//     // ✔ 1. If single Buy Now item → show ONLY that
//     if (single) {
//       setItems([single]);
//       return;
//     }

//     // ✔ 2. Otherwise use cart checkout items ONLY
//     if (cartItems && cartItems.length > 0) {
//       setItems(cartItems);
//       return;
//     }

//     navigate("/products"); // nothing available → redirect
//   }, []);

//   const total = items.reduce((s, i) => s + i.price * i.quantity, 0);

//   const proceedToPayment = () => {
//     const user_id = localStorage.getItem("user_id");

//     const orderData = {
//       user_id: parseInt(user_id),
//       total_price: total,
//       items: items.map((i) => ({
//         product_id: i.id,
//         quantity: i.quantity,
//         price: i.price,
//       })),
//     };

//     navigate("/orders/payment", { state: { orderData } });
//   };

//   return (
//     <div className="checkout-page">
//         <h2>Checkout</h2>

//         {items.map((p) => (
//           <div key={p.id} className="checkout-card">
//             <img src={p.image_url} alt={p.name} className="chk-img" />
//             <div>
//               <h3>{p.name}</h3>
//               <p>Price: ₹{p.price}</p>
//               <p>Quantity: {p.quantity || 1}</p>
//             </div>
//           </div>
//         ))}

//         <h3>Total: ₹{total}</h3>

//         <button className="order-btn" onClick={proceedToPayment}>
//           Proceed to Pay
//         </button>
//     </div>
//   );
// };

// export default Checkout;


// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./Checkout.css";

// const Checkout = () => {
//   const navigate = useNavigate();
//   const [items, setItems] = useState([]);

//   useEffect(() => {
//     const userId = localStorage.getItem("user_id");

//     const single = JSON.parse(localStorage.getItem("checkoutItem"));
//     const cartItems = JSON.parse(localStorage.getItem(`cartCheckout_${userId}`));

//     if (single) {
//       setItems([single]);
//       return;
//     }

//     if (cartItems && cartItems.length > 0) {
//       setItems(cartItems);
//       return;
//     }

//     navigate("/products");
//   }, []);

//   const changeQty = (id, delta) => {
//     setItems((prev) =>
//       prev.map((i) =>
//         i.id === id
//           ? { ...i, quantity: Math.max(1, (i.quantity || 1) + delta) }
//           : i
//       )
//     );
//   };

//   const total = items.reduce((s, i) => s + i.price * (i.quantity || 1), 0);

//   const proceedToPayment = () => {
//     const user_id = localStorage.getItem("user_id");

//     const orderData = {
//       user_id: parseInt(user_id),
//       total_price: total,
//       items: items.map((i) => ({
//         product_id: i.id,
//         quantity: i.quantity,
//         price: i.price,
//       })),
//     };

//     navigate("/orders/payment", { state: { orderData } });
//   };

//   return (
//     <div className="checkout-page">
//       <div className="checkout-box">
//         <h2 className="title">Checkout</h2>

//         {items.map((p) => (
//           <div key={p.id} className="checkout-card">
//             <img src={p.image_url} alt={p.name} className="chk-img" />
//             <div className="chk-details">
//               <h3>{p.name}</h3>
//               <p className="price">₹{p.price}</p>

//               <div className="qty-control">
//                 <button onClick={() => changeQty(p.id, -1)}>-</button>
//                 <span>{p.quantity || 1}</span>
//                 <button onClick={() => changeQty(p.id, 1)}>+</button>
//               </div>

//               <p className="sub">Subtotal: ₹{p.price * (p.quantity || 1)}</p>
//             </div>
//           </div>
//         ))}

//         <div className="summary">
//           <h3>Total: ₹{total}</h3>
//           <button className="order-btn" onClick={proceedToPayment}>
//             Proceed to Pay
//           </button>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Checkout;


import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Checkout.css";

const Checkout = () => {
  const navigate = useNavigate();
  const [items, setItems] = useState([]);

  useEffect(() => {
    const userId = localStorage.getItem("user_id");

    const single = JSON.parse(localStorage.getItem("checkoutItem"));
    const cartItems = JSON.parse(localStorage.getItem(`cartCheckout_${userId}`));

    if (single) {
      setItems([single]);
      return;
    }

    if (cartItems && cartItems.length > 0) {
      setItems(cartItems);
      return;
    }

    navigate("/products");
  }, []);

  const updateQty = (id, change) => {
    setItems((prev) =>
      prev.map((p) =>
        p.id === id ? { ...p, quantity: Math.max(1, (p.quantity || 1) + change) } : p
      )
    );
  };

  const total = items.reduce((s, i) => s + i.price * (i.quantity || 1), 0);

  const proceedToPayment = () => {
    const userId = localStorage.getItem("user_id");

    const orderData = {
      user_id: parseInt(userId),
      total_price: total,
      items: items.map((i) => ({
        product_id: i.id,
        quantity: i.quantity,
        price: i.price,
      })),
    };

    navigate("/orders/payment", { state: { orderData } });
  };

  return (
    <div className="checkout-container">
      <div className="checkout-card-box">
        <h2 className="checkout-title">Checkout</h2>

        {items.map((p) => (
          <div key={p.id} className="checkout-item-card">
            <img src={p.image_url} alt={p.name} className="chk-img" />

            <div className="chk-details">
              <h3>{p.name}</h3>
              <p className="chk-price">₹{p.price}</p>

              <div className="qty-box">
                <button onClick={() => updateQty(p.id, -1)}>-</button>
                <span>{p.quantity || 1}</span>
                <button onClick={() => updateQty(p.id, 1)}>+</button>
              </div>

              <p className="chk-sub">Subtotal: ₹{p.price * (p.quantity || 1)}</p>
            </div>
          </div>
        ))}

        <div className="total-row">
          <h3>Total: ₹{total}</h3>
          <button className="pay-btn" onClick={proceedToPayment}>
            Proceed to Pay
          </button>
        </div>
      </div>
    </div>
  );
};

export default Checkout;

