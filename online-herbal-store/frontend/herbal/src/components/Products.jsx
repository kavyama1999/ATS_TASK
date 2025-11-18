


// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "../pages/Products.css";

// const Products = () => {
//   const [products, setProducts] = useState([]);
//   const navigate = useNavigate();

//   useEffect(() => {
//     fetchProducts();
//   }, []);

//   const fetchProducts = async () => {
//     try {
//       const response = await api.get("/products/");
//       setProducts(response.data);
//     } catch (error) {
//       console.error("Error fetching products:", error);
//     }
//   };

//   const getCart = (userId) =>
//     JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];

//   const saveCart = (userId, cart) =>
//     localStorage.setItem(`cart_${userId}`, JSON.stringify(cart));

//   const handleAddToCart = (product) => {
//     const userId = localStorage.getItem("user_id");
//     if (!userId) {
//       alert("⚠️ Please login first.");
//       navigate("/user-login");
//       return;
//     }

//     const cart = getCart(userId);
//     const existing = cart.find((item) => item.id === product.id);

//     if (existing) {
//       existing.quantity += 1;
//     } else {
//       cart.push({ ...product, quantity: 1 });
//     }

//     saveCart(userId, cart);

//     window.dispatchEvent(new Event("storage")); // update navbar count
//     navigate("/orders/cart");
//   };

//   const handleBuyNow = (product) => {
//     const userId = localStorage.getItem("user_id");
//     if (!userId) {
//       alert("⚠️ Please login.");
//       navigate("/user-login");
//       return;
//     }

//     localStorage.setItem("checkoutItem", JSON.stringify({ ...product, quantity: 1 }));
//     navigate("/orders/checkout");
//   };

//   return (
//     <div className="products-container">
//       <h1 className="products-title">🌿 Our Herbal Products</h1>

//       <div className="product-grid">
//         {products.map((product) => (
//           <div className="card" key={product.id}>
//             <img
//               src={product.image_url}
//               alt={product.name}
//               onError={(e) => (e.target.src = "https://via.placeholder.com/300x200")}
//             />
//             <h1>{product.name}</h1>
//             <p className="price">₹{product.price}</p>
//             <p>{product.description}</p>

//             <div className="button-group">
//               <button onClick={() => handleAddToCart(product)}>Add to Cart</button>
//               <button className="buy-now" onClick={() => handleBuyNow(product)}>
//                 Buy Now
//               </button>
//             </div>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default Products;



import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import api from "../api/axios";
import "../pages/Products.css";

const Products = () => {
  const [products, setProducts] = useState([]);
  const [filtered, setFiltered] = useState([]);

  const navigate = useNavigate();
  const location = useLocation();

  // 👉 Get ?search=value from URL
  const searchQuery =
    new URLSearchParams(location.search).get("search")?.toLowerCase() || "";

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await api.get("/products/");
      setProducts(response.data);
      setFiltered(response.data); // default show all
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  };

  // 👉 FILTER BASED ON SEARCH TEXT
  useEffect(() => {
    if (searchQuery.trim() === "") {
      setFiltered(products);
      return;
    }

    const results = products.filter((p) => {
      return (
        p.name.toLowerCase().includes(searchQuery) ||
        p.description.toLowerCase().includes(searchQuery) ||
        (p.category?.toLowerCase().includes(searchQuery) || "")
      );
    });

    setFiltered(results);
  }, [searchQuery, products]);

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
    navigate("/orders/cart");
  };

  const handleBuyNow = (product) => {
    const userId = localStorage.getItem("user_id");
    if (!userId) {
      alert("⚠️ Please login.");
      navigate("/user-login");
      return;
    }

    localStorage.setItem("checkoutItem", JSON.stringify({ ...product, quantity: 1 }));
    navigate("/orders/checkout");
  };

  return (
    <div className="products-container">
      <h1 className="products-title">🌿 Our Herbal Products</h1>

      {/* Show search info */}
      {searchQuery && (
        <p style={{ fontSize: "18px", marginBottom: "10px" }}>
          Showing results for <b>"{searchQuery}"</b>
        </p>
      )}

      <div className="product-grid">
        {filtered.map((product) => (
          <div className="card" key={product.id}>
            <img
              src={product.image_url}
              alt={product.name}
              onError={(e) => (e.target.src = "https://via.placeholder.com/300x200")}
            />
            <h1>{product.name}</h1>
            <p className="price">₹{product.price}</p>
            <p>{product.description}</p>

            <div className="button-group">
              <button onClick={() => handleAddToCart(product)}>Add to Cart</button>
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
