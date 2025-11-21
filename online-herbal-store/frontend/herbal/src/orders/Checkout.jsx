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

