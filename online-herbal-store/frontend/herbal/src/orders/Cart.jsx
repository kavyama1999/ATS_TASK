import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Cart.css";

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);
  const [selectedItems, setSelectedItems] = useState([]); // ✅ selected items for checkout
  const [total, setTotal] = useState(0);
  const navigate = useNavigate();

  // ✅ Load cart from localStorage
  useEffect(() => {
    const userId = localStorage.getItem("user_id");
    if (!userId) {
      alert("⚠️ Please login to view your cart!");
      navigate("/login");
      return;
    }

    const savedCart = JSON.parse(localStorage.getItem("cart")) || [];
    setCartItems(savedCart);
  }, [navigate]);

  // ✅ Calculate total for selected items
  useEffect(() => {
    const selectedTotal = selectedItems.reduce((sum, id) => {
      const item = cartItems.find((p) => p.id === id);
      return item ? sum + item.price * item.quantity : sum;
    }, 0);
    setTotal(selectedTotal);
  }, [cartItems, selectedItems]);

  // ✅ Update quantity
  const updateQuantity = (index, change) => {
    const updated = [...cartItems];
    const item = updated[index];
    item.quantity = Math.max(1, item.quantity + change);
    setCartItems(updated);
    localStorage.setItem("cart", JSON.stringify(updated));
  };

  // ✅ Remove item
  const removeItem = (index) => {
    const updated = cartItems.filter((_, i) => i !== index);
    setCartItems(updated);
    localStorage.setItem("cart", JSON.stringify(updated));
  };

  // ✅ Select/unselect item for checkout
  const toggleSelect = (id) => {
    if (selectedItems.includes(id)) {
      setSelectedItems(selectedItems.filter((itemId) => itemId !== id));
    } else {
      setSelectedItems([...selectedItems, id]);
    }
  };

  // ✅ Proceed to checkout
  const proceedToCheckout = () => {
    if (selectedItems.length === 0) {
      alert("Please select at least one item to proceed.");
      return;
    }

    const selectedProducts = cartItems.filter((p) =>
      selectedItems.includes(p.id)
    );
    localStorage.setItem("checkoutItems", JSON.stringify(selectedProducts));

    navigate("/orders/checkout");
  };

  // ✅ View Product Details
  const viewProductDetails = (productId) => {
    navigate(`/product/${productId}`);
  };

  return (
    <div className="cart-container">
      <h2 className="cart-header">🛒 Your Shopping Cart</h2>

      {cartItems.length === 0 ? (
        <p className="cart-empty">
          Your cart is empty. Add some herbal goodness 🌿!
        </p>
      ) : (
        <>
          <div className="cart-list">
            {cartItems.map((item, i) => (
              <div key={i} className="cart-item">
                {/* ✅ Select Checkbox */}
                <input
                  type="checkbox"
                  checked={selectedItems.includes(item.id)}
                  onChange={() => toggleSelect(item.id)}
                  className="cart-checkbox"
                />

                {/* ✅ Product Image and Info */}
                <div
                  className="cart-item-left"
                  onClick={() => viewProductDetails(item.id)}
                >
                  <img
                    src={item.image_url || "https://via.placeholder.com/100"}
                    alt={item.name}
                  />
                  <div className="cart-item-info">
                    <h3>{item.name}</h3>
                    <p>{item.description?.slice(0, 60)}...</p>
                    <p className="price">₹{item.price}</p>
                  </div>
                </div>

                {/* ✅ Quantity controls */}
                <div className="quantity-controls">
                  <button onClick={() => updateQuantity(i, -1)}>-</button>
                  <span>{item.quantity}</span>
                  <button onClick={() => updateQuantity(i, 1)}>+</button>
                </div>

                {/* ✅ Remove */}
                <button
                  className="cart-remove"
                  onClick={() => removeItem(i)}
                >
                  Remove
                </button>
              </div>
            ))}
          </div>

          {/* ✅ Summary section */}
          <div className="cart-summary">
            <h3>
              Selected Items: {selectedItems.length} | Total: ₹{total}
            </h3>
            <button onClick={proceedToCheckout}>
              💳 Proceed to Pay
            </button>
          </div>
        </>
      )}
    </div>
  );
};

export default Cart;
