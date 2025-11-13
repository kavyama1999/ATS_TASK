

// // export default Products;

// import React, { useEffect, useState } from "react";
// import api from "../api/axios";

// // ✅ IMPORT CSS FROM pages folder
//  import "../pages/Products.css";

// const Products = () => {
//   const [products, setProducts] = useState([]);

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

//   return (
//     <div className="products-container">
//       <h1 className="products-title">🌿 Our Herbal Products</h1>

//       <div className="product-grid">
//         {products.map((product) => (
//           <div className="card" key={product.id}>
//             <img
//               src={product.image_url}
//               alt={product.name}
//               onError={(e) =>
//                 (e.target.src = "https://via.placeholder.com/300x200")
//               }
//             />

//             <h1>{product.name}</h1>
//             <p className="price">₹{product.price}</p>
//             <p>{product.description}</p>
//             <button>Add to Cart</button>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default Products;

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

//   // ✅ Add to Cart — only if user logged in
//   const handleAddToCart = (product) => {
//     const user = JSON.parse(localStorage.getItem("user"));
//     if (!user) {
//       alert("Please login or register before adding to cart.");
//       navigate("/login");
//       return;
//     }

//     let cart = JSON.parse(localStorage.getItem("cart")) || [];
//     const existing = cart.find((item) => item.id === product.id);
//     if (existing) {
//       existing.quantity += 1;
//     } else {
//       cart.push({ ...product, quantity: 1 });
//     }
//     localStorage.setItem("cart", JSON.stringify(cart));
//     alert(`${product.name} added to cart!`);
//   };

//   // ✅ Buy Now — only if user logged in
//   const handleBuyNow = (product) => {
//     const user = JSON.parse(localStorage.getItem("user"));
//     if (!user) {
//       alert("Please login or register before purchasing.");
//       navigate("/login");
//       return;
//     }

//     // Store this product in localStorage for checkout
//     localStorage.setItem("checkoutItem", JSON.stringify(product));
//     navigate("/checkout"); // go to checkout or payment page
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
//               onError={(e) =>
//                 (e.target.src = "https://via.placeholder.com/300x200")
//               }
//             />

//             <h1>{product.name}</h1>
//             <p className="price">₹{product.price}</p>
//             <p>{product.description}</p>

//             <div className="button-group">
//               <button onClick={() => handleAddToCart(product)}>
//                 Add to Cart
//               </button>
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


// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "../pages/Products.css";

// const Products = () => {
//   const [products, setProducts] = useState([]);
//   const navigate = useNavigate();

//   // 🔹 Fetch all active products from backend
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

//   // ✅ Add to Cart — only if user is logged in
//   const handleAddToCart = (product) => {
//     const userId = localStorage.getItem("user_id"); // stored when logged in

//     if (!userId) {
//       alert("⚠️ Please login or register before adding to cart.");
//       navigate("/login");
//       return;
//     }

//     let cart = JSON.parse(localStorage.getItem("cart")) || [];
//     const existing = cart.find((item) => item.id === product.id);

//     if (existing) {
//       existing.quantity += 1;
//     } else {
//       cart.push({ ...product, quantity: 1 });
//     }

//     localStorage.setItem("cart", JSON.stringify(cart));
//     alert(`✅ ${product.name} added to cart!`);
//     navigate("/orders/cart"); // 👈 redirect to cart page
//   };

//   // ✅ Buy Now — only if user is logged in
//   const handleBuyNow = (product) => {
//     const userId = localStorage.getItem("user_id");

//     if (!userId) {
//       alert("⚠️ Please login or register before purchasing.");
//       navigate("/login");
//       return;
//     }

//     // Store selected product in localStorage for checkout
//     const checkoutItem = { ...product, quantity: 1 };
//     localStorage.setItem("checkoutItem", JSON.stringify(checkoutItem));

//     // Optional: add this to cart too
//     localStorage.setItem("cart", JSON.stringify([checkoutItem]));

//     navigate("/orders/checkout"); // 👈 go to checkout page
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
//               onError={(e) =>
//                 (e.target.src = "https://via.placeholder.com/300x200")
//               }
//             />

//             <h1>{product.name}</h1>
//             <p className="price">₹{product.price}</p>
//             <p>{product.description}</p>

//             <div className="button-group">
//               <button onClick={() => handleAddToCart(product)}>
//                 Add to Cart
//               </button>
//               <button
//                 className="buy-now"
//                 onClick={() => handleBuyNow(product)}
//               >
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
import { useNavigate } from "react-router-dom";
import api from "../api/axios";
import "../pages/Products.css";

const Products = () => {
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

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

  const handleAddToCart = (product) => {
    const userId = localStorage.getItem("user_id");

    if (!userId) {
      alert("⚠️ Please login or register before adding to cart.");
      navigate("/login");
      return;
    }

    let cart = JSON.parse(localStorage.getItem("cart")) || [];
    const existing = cart.find((item) => item.id === product.id);

    if (existing) {
      existing.quantity += 1;
    } else {
      cart.push({ ...product, quantity: 1 });
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    alert(`✅ ${product.name} added to cart!`);
    navigate("/orders/cart");
  };

  const handleBuyNow = (product) => {
    const userId = localStorage.getItem("user_id");

    if (!userId) {
      alert("⚠️ Please login or register before purchasing.");
      navigate("/login");
      return;
    }

    const checkoutItem = { ...product, quantity: 1 };
    localStorage.setItem("checkoutItem", JSON.stringify(checkoutItem));
    navigate("/orders/checkout");
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

            <div className="button-group">
              <button onClick={() => handleAddToCart(product)}>
                Add to Cart
              </button>
              <button
                className="buy-now"
                onClick={() => handleBuyNow(product)}
              >
                Buy Now
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Products;
