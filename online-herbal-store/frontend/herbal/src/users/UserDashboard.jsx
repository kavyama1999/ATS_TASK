import { useState, useEffect } from "react";
import "./UserDashboard.css";

function UserDashboard() {
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);

  // Load products from API
  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await api.get("/products"); // your endpoint
        setProducts(response.data);
      } catch (err) {
        console.error(err);
      }
    };
    fetchProducts();
  }, []);

  // Load cart from localStorage
  useEffect(() => {
    const savedCart = localStorage.getItem("userCart");
    if (savedCart) setCart(JSON.parse(savedCart));
  }, []);

  // Add product to cart
  const addToCart = (product) => {
    const updatedCart = [...cart, product];
    setCart(updatedCart);
    localStorage.setItem("userCart", JSON.stringify(updatedCart));
  };

  return (
    <div className="user-dashboard">
      <h1>🛍️ Products</h1>

      <div className="cart-preview">
        <h2>🛒 Your Cart ({cart.length} items)</h2>
        {cart.length === 0 ? (
          <p>Cart is empty</p>
        ) : (
          <ul>
            {cart.map((item, idx) => (
              <li key={idx}>{item.name} - ${item.price}</li>
            ))}
          </ul>
        )}
      </div>

      <div className="products-grid">
        {products.map((product) => (
          <div key={product.id} className="product-card">
            <img src={product.image_url} alt={product.name} />
            <h3>{product.name}</h3>
            <p>${product.price}</p>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default UserDashboard;
