// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./Checkout.css";

// const Checkout = () => {
//   const navigate = useNavigate();
//   const [product, setProduct] = useState(null);
//   const [quantity, setQuantity] = useState(1);
//   const [total, setTotal] = useState(0);
//   const [message, setMessage] = useState("");

//   useEffect(() => {
//     const checkoutItem = JSON.parse(localStorage.getItem("checkoutItem"));
//     if (!checkoutItem) {
//       navigate("/");
//       return;
//     }
//     setProduct(checkoutItem);
//     setTotal(checkoutItem.price);
//   }, [navigate]);

//   const handleQuantityChange = (type) => {
//     setQuantity((prev) => {
//       const newQty = type === "inc" ? prev + 1 : prev > 1 ? prev - 1 : 1;
//       setTotal(product.price * newQty);
//       return newQty;
//     });
//   };

//   const handlePayment = async () => {
//     const user_id = localStorage.getItem("user_id");
//     if (!user_id) {
//       alert("Please login first");
//       navigate("/login");
//       return;
//     }

//     try {
//       const orderData = {
//         user_id: parseInt(user_id),
//         total_price: total,
//         items: [
//           {
//             product_id: product.id,
//             quantity,
//             price: product.price,
//           },
//         ],
//       };

//       const response = await api.post("/orders/", orderData);
//       setMessage(`✅ Payment successful! Order #${response.data.id} placed.`);
//       localStorage.removeItem("checkoutItem");

//       setTimeout(() => navigate("/orders"), 2000);
//     } catch (error) {
//       console.error("Order creation failed:", error);
//       setMessage("❌ Payment failed. Please try again.");
//     }
//   };

//   if (!product) return null;

//   return (
//     <div className="checkout-container">
//       <div className="checkout-card">
//         <h1 className="checkout-header">💳 Checkout</h1>

//         <div className="checkout-content">
//           <div className="checkout-image">
//             <img
//               src={product.image_url || "https://via.placeholder.com/250"}
//               alt={product.name}
//             />
//           </div>

//           <div className="checkout-details">
//             <h2>{product.name}</h2>
//             <p>{product.description}</p>
//             <p className="checkout-price">Price: ₹{product.price}</p>

//             <div className="quantity-control">
//               <button onClick={() => handleQuantityChange("dec")}>−</button>
//               <span>{quantity}</span>
//               <button onClick={() => handleQuantityChange("inc")}>+</button>
//             </div>

//             <p className="total-price">Total: ₹{total}</p>

//             <button className="pay-btn" onClick={handlePayment}>
//               💰 Pay Now & Place Order
//             </button>

//             {message && <p className="checkout-message">{message}</p>}
//           </div>
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
  const [message, setMessage] = useState("");

  useEffect(() => {
    // ✅ Check both cart-based and buy-now-based checkouts
    const checkoutItems =
      JSON.parse(localStorage.getItem("checkoutItems")) ||
      (JSON.parse(localStorage.getItem("checkoutItem"))
        ? [JSON.parse(localStorage.getItem("checkoutItem"))]
        : []);

    if (!checkoutItems.length) {
      navigate("/");
      return;
    }

    setItems(checkoutItems);
    setTotal(
      checkoutItems.reduce((sum, i) => sum + i.price * (i.quantity || 1), 0)
    );
  }, [navigate]);

  const handleQuantityChange = (index, type) => {
    const updated = [...items];
    const item = updated[index];
    if (type === "inc") item.quantity += 1;
    else if (type === "dec" && item.quantity > 1) item.quantity -= 1;
    setItems(updated);
    setTotal(updated.reduce((sum, i) => sum + i.price * i.quantity, 0));
  };

  const handlePayment = async () => {
    const user_id = localStorage.getItem("user_id");
    if (!user_id) {
      alert("Please login first!");
      navigate("/login");
      return;
    }

    try {
      const orderData = {
        user_id: parseInt(user_id),
        total_price: total,
        items: items.map((i) => ({
          product_id: i.id,
          quantity: i.quantity,
          price: i.price,
        })),
      };

      const response = await api.post("/orders/", orderData);
      setMessage(`✅ Payment successful! Order #${response.data.id} placed.`);

      // Clear localStorage after successful order
      localStorage.removeItem("checkoutItems");
      localStorage.removeItem("checkoutItem");
      localStorage.removeItem("cart");

      // Redirect to success page
      setTimeout(() => navigate("/orders/ordersuccess"), 2000);
    } catch (error) {
      console.error("Order creation failed:", error);
      setMessage("❌ Payment failed. Please try again.");
    }
  };

  if (!items.length) return null;

  return (
    <div className="checkout-container">
      <h1 className="checkout-header">💳 Checkout</h1>

      <div className="checkout-list">
        {items.map((item, i) => (
          <div key={i} className="checkout-card">
            <img
              src={item.image_url || "https://via.placeholder.com/150"}
              alt={item.name}
              className="checkout-img"
            />
            <div className="checkout-info">
              <h3>{item.name}</h3>
              <p>{item.description}</p>
              <p>Price: ₹{item.price}</p>

              <div className="quantity-control">
                <button onClick={() => handleQuantityChange(i, "dec")}>−</button>
                <span>{item.quantity}</span>
                <button onClick={() => handleQuantityChange(i, "inc")}>+</button>
              </div>

              <p className="item-total">
                Subtotal: ₹{item.price * item.quantity}
              </p>
            </div>
          </div>
        ))}
      </div>

      <div className="checkout-summary">
        <h2>Total Amount: ₹{total}</h2>
        <button className="pay-btn" onClick={handlePayment}>
          💰 Pay Now & Place Order
        </button>
        {message && <p className="checkout-message">{message}</p>}
      </div>
    </div>
  );
};

export default Checkout;
