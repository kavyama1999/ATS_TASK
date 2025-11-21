

// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./Cart.css";

// const Cart = () => {
//   const navigate = useNavigate();
//   const [cart, setCart] = useState([]);
//   const [selectedItems, setSelectedItems] = useState([]);

//   const userId = localStorage.getItem("user_id");

//   useEffect(() => {
//     if (!userId) {
//       alert("Please login first.");
//       navigate("/user-login");
//       return;
//     }

//     const saved = JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];
//     setCart(saved);
//     setSelectedItems(saved.map((i) => i.id));
//   }, []);

//   const updateCart = (newCart) => {
//     localStorage.setItem(`cart_${userId}`, JSON.stringify(newCart));
//     setCart(newCart);
//     window.dispatchEvent(new Event("storage"));
//   };

//   const toggleSelect = (id) => {
//     setSelectedItems((prev) =>
//       prev.includes(id) ? prev.filter((x) => x !== id) : [...prev, id]
//     );
//   };

//   const changeQty = (id, delta) => {
//     const updated = cart.map((i) =>
//       i.id === id ? { ...i, quantity: Math.max(1, i.quantity + delta) } : i
//     );
//     updateCart(updated);
//   };

//   const total = cart
//     .filter((i) => selectedItems.includes(i.id))
//     .reduce((s, i) => s + i.price * i.quantity, 0);

//   const proceedToPay = () => {
//     const selected = cart.filter((i) => selectedItems.includes(i.id));

//     if (selected.length === 0) {
//       alert("Please select at least one item.");
//       return;
//     }

//     // ✅ Store ONLY selected checkout items
//     localStorage.setItem("cartCheckout", JSON.stringify(selected));

//     // Go to checkout page
//     navigate("/orders/checkout");
//   };

//   return (
//     <div className="cart-wrapper">
//       <h2 className="cart-title">Your Cart</h2>

//       <div className="cart-box">
//         {cart.map((item) => (
//           <div key={item.id} className="cart-card">
//             <input
//               type="checkbox"
//               checked={selectedItems.includes(item.id)}
//               onChange={() => toggleSelect(item.id)}
//               className="cart-check"
//             />

//             <img src={item.image_url} alt={item.name} className="cart-img" />

//             <div className="cart-info">
//               <h3>{item.name}</h3>
//               <p className="price">₹{item.price}</p>

//               <div className="qty-box">
//                 <button onClick={() => changeQty(item.id, -1)}>-</button>
//                 <span>{item.quantity}</span>
//                 <button onClick={() => changeQty(item.id, 1)}>+</button>
//               </div>

//               <p className="sub">Subtotal: ₹{item.price * item.quantity}</p>
//             </div>

//             <button
//               className="remove-btn"
//               onClick={() => updateCart(cart.filter((x) => x.id !== item.id))}
//             >
//               Remove
//             </button>
//           </div>
//         ))}
//       </div>

//       <div className="cart-footer">
//         <h3>Total: ₹{total}</h3>

//         <button className="pay-btn" onClick={proceedToPay}>
//           Proceed to Pay ₹{total}
//         </button>
//       </div>
//     </div>
//   );
// };

// export default Cart;




//today
// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import "./Cart.css";

// const Cart = () => {
//   const navigate = useNavigate();
//   const [cart, setCart] = useState([]);
//   const [selectedItems, setSelectedItems] = useState([]);

//   const userId = localStorage.getItem("user_id");

//   useEffect(() => {
//     if (!userId) {
//       alert("Please login first.");
//       navigate("/user-login");
//       return;
//     }

//     const saved = JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];
//     setCart(saved);
//     setSelectedItems(saved.map((i) => i.id));
//   }, []);

//   const updateCart = (newCart) => {
//     localStorage.setItem(`cart_${userId}`, JSON.stringify(newCart));
//     setCart(newCart);
//     window.dispatchEvent(new Event("storage"));
//   };

//   const toggleSelect = (id) => {
//     setSelectedItems((prev) =>
//       prev.includes(id) ? prev.filter((x) => x !== id) : [...prev, id]
//     );
//   };

//   const changeQty = (id, delta) => {
//     const updated = cart.map((i) =>
//       i.id === id ? { ...i, quantity: Math.max(1, i.quantity + delta) } : i
//     );
//     updateCart(updated);
//   };

//   const total = cart
//     .filter((i) => selectedItems.includes(i.id))
//     .reduce((s, i) => s + i.price * i.quantity, 0);

//   const proceedToPay = () => {
//     const selected = cart.filter((i) => selectedItems.includes(i.id));

//     if (selected.length === 0) {
//       alert("Please select at least one item.");
//       return;
//     }

//     // FIX: Store checkout items USING USER ID → avoids wrong product loading
//     localStorage.setItem(`cartCheckout_${userId}`, JSON.stringify(selected));

//     // Remove single-buy if exists
//     localStorage.removeItem("checkoutItem");

//     navigate("/orders/checkout");
//   };

//   return (
//     <div className="cart-wrapper">
//       <h2 className="cart-title">Your Cart</h2>

//       <div className="cart-box">
//         {cart.map((item) => (
//           <div key={item.id} className="cart-card">
//             <input
//               type="checkbox"
//               checked={selectedItems.includes(item.id)}
//               onChange={() => toggleSelect(item.id)}
//               className="cart-check"
//             />

//             <img src={item.image_url} alt={item.name} className="cart-img" />

//             <div className="cart-info">
//               <h3>{item.name}</h3>
//               <p className="price">₹{item.price}</p>

//               <div className="qty-box">
//                 <button onClick={() => changeQty(item.id, -1)}>-</button>
//                 <span>{item.quantity}</span>
//                 <button onClick={() => changeQty(item.id, 1)}>+</button>
//               </div>

//               <p className="sub">Subtotal: ₹{item.price * item.quantity}</p>
//             </div>

//             <button
//               className="remove-btn"
//               onClick={() => updateCart(cart.filter((x) => x.id !== item.id))}
//             >
//               Remove
//             </button>
//           </div>
//         ))}
//       </div>

//       <div className="cart-footer">
//         <h3>Total: ₹{total}</h3>

//         <button className="pay-btn" onClick={proceedToPay}>
//           Proceed to Pay ₹{total}
//         </button>
//       </div>
//     </div>
//   );
// };

// export default Cart;


import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Cart.css";

const Cart = () => {
  const navigate = useNavigate();
  const [cart, setCart] = useState([]);
  const [selectedItems, setSelectedItems] = useState([]);

  const userId = localStorage.getItem("user_id");

  useEffect(() => {
    if (!userId) {
      alert("Please login first.");
      navigate("/user-login");
      return;
    }

    const saved = JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];
    setCart(saved);
    setSelectedItems(saved.map((i) => i.id));
  }, []);

  const updateCart = (newCart) => {
    localStorage.setItem(`cart_${userId}`, JSON.stringify(newCart));
    setCart(newCart);
  };

  const toggleSelect = (id) => {
    setSelectedItems((prev) =>
      prev.includes(id) ? prev.filter((x) => x !== id) : [...prev, id]
    );
  };

  const changeQty = (id, delta) => {
    const updated = cart.map((i) =>
      i.id === id ? { ...i, quantity: Math.max(1, i.quantity + delta) } : i
    );
    updateCart(updated);
  };

  const total = cart
    .filter((i) => selectedItems.includes(i.id))
    .reduce((s, i) => s + i.price * i.quantity, 0);

  const proceedToPay = () => {
    const selected = cart.filter((i) => selectedItems.includes(i.id));

    if (selected.length === 0) {
      alert("Please select at least one product!");
      return;
    }

    // Save items for checkout
    localStorage.setItem(`cartCheckout_${userId}`, JSON.stringify(selected));

    // Remove single-buy if exists
    localStorage.removeItem("checkoutItem");

    navigate("/orders/checkout");
  };

  return (
    <div className="cart-wrapper">
      <h2 className="cart-title">Your Cart</h2>

      <div className="cart-box">
        {cart.map((item) => (
          <div key={item.id} className="cart-card">
            {/* <input
              type="checkbox"
              checked={selectedItems.includes(item.id)}
              onChange={() => toggleSelect(item.id)}
            /> */}
            <input
              type="checkbox"
              className="big-checkbox"
              checked={selectedItems.includes(item.id)}
              onChange={() => toggleSelect(item.id)}
            />


            <img src={item.image_url} alt={item.name} className="cart-img" />

            <div className="cart-info">
              <h3>{item.name}</h3>
              <p className="price">₹{item.price}</p>

              <div className="qty-box">
                <button onClick={() => changeQty(item.id, -1)}>-</button>
                <span>{item.quantity}</span>
                <button onClick={() => changeQty(item.id, 1)}>+</button>
              </div>

              <p>Subtotal: ₹{item.price * item.quantity}</p>
            </div>

            <button
              className="remove-btn"
              onClick={() => updateCart(cart.filter((x) => x.id !== item.id))}
            >
              Remove
            </button>
          </div>
        ))}
      </div>

      <div className="cart-footer">
        <h3>Total: ₹{total}</h3>
        <button className="pay-btn" onClick={proceedToPay}>
          Proceed to Pay ₹{total}
        </button>
      </div>
    </div>
  );
};

export default Cart;
