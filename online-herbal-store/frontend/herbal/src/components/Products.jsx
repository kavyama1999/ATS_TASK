
import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import api from "../api/axios";
import "../pages/Products.css";

const Products = () => {
  const [products, setProducts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [successMsg, setSuccessMsg] = useState(""); // ⭐ NEW STATE

  const navigate = useNavigate();
  const location = useLocation();

  const searchQuery =
    new URLSearchParams(location.search).get("search")?.toLowerCase() || "";

  const getCategory = (name) => {
    const n = name.toLowerCase();

    if (n.includes("oil")) return "Herbal Oils";
    if (n.includes("skin") || n.includes("face") || n.includes("cream"))
      return "Skin Care";
    if (n.includes("hair") || n.includes("shampoo")) return "Hair Care";
    if (n.includes("juice") || n.includes("extract"))
      return "Juices & Extracts";
    if (n.includes("soap")) return "Soaps";
    if (n.includes("powder")) return "Herbal Powders";

    return "Others";
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await api.get("/products/");
      const updatedData = response.data.map((p) => ({
        ...p,
        category: getCategory(p.name),
      }));

      setProducts(updatedData);
      setFiltered(updatedData);
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  };

  useEffect(() => {
    let result = [...products];

    if (searchQuery.trim() !== "") {
      result = result.filter(
        (p) =>
          p.name.toLowerCase().includes(searchQuery) ||
          p.description.toLowerCase().includes(searchQuery) ||
          p.category.toLowerCase().includes(searchQuery)
      );
    }

    if (selectedCategory !== "All") {
      result = result.filter((p) => p.category === selectedCategory);
    }

    setFiltered(result);
  }, [searchQuery, selectedCategory, products]);

  const categories = [
    "All",
    "Herbal Oils",
    "Skin Care",
    "Hair Care",
    "Herbal Powders",
    "Soaps",
  ];

  const handleCategoryClick = (cat) => {
    setSelectedCategory(cat);
  };

  const getCart = (userId) =>
    JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];

  const saveCart = (userId, cart) =>
    localStorage.setItem(`cart_${userId}`, JSON.stringify(cart));

  const handleAddToCart = (product) => {
    const userId = localStorage.getItem("user_id");
    if (!userId) {
      alert("⚠️ Please login first.");
      navigate("/user-login");
      return;
    }

    const cart = getCart(userId);
    const existing = cart.find((item) => item.id === product.id);

    if (existing) existing.quantity += 1;
    else cart.push({ ...product, quantity: 1 });

    saveCart(userId, cart);
    window.dispatchEvent(new Event("storage"));

    // ⭐ SHOW SUCCESS MESSAGE
    setSuccessMsg("Product is added to cart ");

    // ⭐ HIDE AFTER 2 SECONDS
    setTimeout(() => setSuccessMsg(""), 2000);
  };

  const handleBuyNow = (product) => {
    const userId = localStorage.getItem("user_id");
    if (!userId) {
      alert("⚠️ Please login.");
      navigate("/user-login");
      return;
    }

    localStorage.removeItem("cartCheckout");
    localStorage.removeItem("checkoutItem");

    localStorage.setItem(
      "checkoutItem",
      JSON.stringify({ ...product, quantity: 1 })
    );

    navigate("/orders/checkout");
  };

  return (
    <div className="products-container">
      {/* <h1 className="products-title">🌿 Herbal Products</h1> */}

      {/* ⭐ SUCCESS MESSAGE */}


      {successMsg && (
        <div className="toast-popup">
          ✓ {successMsg}
        </div>
      )}


      {searchQuery && (
        <p style={{ fontSize: "18px", marginBottom: "10px" }}>
          Showing results for <b>"{searchQuery}"</b>
        </p>
      )}

      <div className="category-bar">
        {categories.map((cat) => (
          <div
            key={cat}
            className={`category-item ${selectedCategory === cat ? "active" : ""
              }`}
            onClick={() => handleCategoryClick(cat)}
          >
            {cat}
          </div>
        ))}
      </div>

      <div className="product-grid">
        {filtered.map((product) => (
          <div className="card" key={product.id}>
            <img
              src={product.image_url}
              alt={product.name}
              onError={(e) =>
                (e.target.src = "https://via.placeholder.com/300x200")
              }
            />
            <h1>{product.name}</h1>
            <p className="price">₹{product.price}</p>
            <p>{product.description}</p>

            <div className="button-group">
              <button onClick={() => handleAddToCart(product)}>
                Add to Cart
              </button>
              <button className="buy-now" onClick={() => handleBuyNow(product)}>
                Buy Now
              </button>
            </div>
          </div>
        ))}
      </div>

      {filtered.length === 0 && (
        <p style={{ textAlign: "center", marginTop: "20px", fontSize: "18px" }}>
          ❌ No matching products found
        </p>
      )}
    </div>
  );
};

export default Products;
