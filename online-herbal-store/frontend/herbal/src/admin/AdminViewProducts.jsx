import React, { useEffect, useState } from "react";
import api from "../api/axios";
import "./AdminViewProducts.css"; //css

const AdminViewProducts = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await api.get("/products/");
      setProducts(response.data);
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  };

  return (
    <div className="admin-products-container">
      <h1 className="admin-products-title">🌿 Product List (Admin View)</h1>

      <div className="admin-product-grid">
        {products.map((product) => (
          <div className="admin-card" key={product.id}>
            <img
              src={product.image_url}
              alt={product.name}
              onError={(e) => (e.target.src = "https://via.placeholder.com/300x200")}
            />
            <h2 className="card-title">{product.name}</h2>
            <p className="price">₹{product.price}</p>
            <p className="desc">{product.description}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AdminViewProducts;
