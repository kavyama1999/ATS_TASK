

// export default Products;

import React, { useEffect, useState } from "react";
import api from "../api/axios";

// ✅ IMPORT CSS FROM pages folder
 import "../pages/Products.css";

const Products = () => {
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
    <div className="products-container">
      <h1 className="products-title">🌿 Our Herbal Products</h1>

      <div className="product-grid">
        {products.map((product) => (
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
            <button>Add to Cart</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Products;

