import React from "react";
import { useNavigate } from "react-router-dom";
import { IoCartOutline } from "react-icons/io5";
import "./CartIcon.css"; // ✅ import the CSS

const CartIcon = ({ cart }) => {
  const navigate = useNavigate();

  const handleClick = () => {
    const userId = localStorage.getItem("user_id");
    if (!userId) {
      alert("⚠️ Please login or register to view your cart.");
      navigate("/user-login");
      return;
    }
    navigate("/orders/cart");
  };

  return (
    <div className="cart-icon" onClick={handleClick}>
      <IoCartOutline />
      {cart.length > 0 && <span className="cart-badge">{cart.length}</span>}
    </div>
  );
};

export default CartIcon;
