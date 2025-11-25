


// import { Link, useNavigate } from "react-router-dom";
// import { useState, useEffect, useRef } from "react";
// import { IoCartOutline } from "react-icons/io5";
// import { FaRegUser, FaUserCircle, FaSignOutAlt } from "react-icons/fa";
// import "./Navbar.css";

// const Navbar = () => {
//   const [cartCount, setCartCount] = useState(0);
//   const [showDropdown, setShowDropdown] = useState(false);
//   const [showLogoutPopup, setShowLogoutPopup] = useState(false);
//   const dropdownRef = useRef(null);
//   const navigate = useNavigate();

//   const userId = localStorage.getItem("user_id");

//   useEffect(() => {
//     loadUserCart();
//     window.addEventListener("storage", loadUserCart);
//     return () => window.removeEventListener("storage", loadUserCart);
//   }, [userId]);

//   const loadUserCart = () => {
//     if (!userId) return setCartCount(0);

//     const cart = JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];
//     setCartCount(cart.length);
//   };

//   // ✅ FIXED LOGOUT — DO NOT DELETE CART DATA
//   const handleConfirmLogout = () => {
//     // ❌ REMOVE THIS — Do not delete user's saved cart
//     // localStorage.removeItem(`cart_${userId}`);

//     // Remove only login session
//     localStorage.removeItem("user_id");

//     // UI should show empty cart
//     setCartCount(0);

//     setShowLogoutPopup(false);
//     navigate("/user-login");
//   };

//   const handleCancelLogout = () => {
//     setShowLogoutPopup(false);
//   };

//   return (
//     <nav className="navbar">
//       <div className="navbar-logo">
//         <Link to="/">🌿 Herbal Store</Link>
//       </div>

//       <ul className="navbar-links">
//         <li><Link to="/">Home</Link></li>
//         <li><Link to="/about">About</Link></li>

//         {/* LOGIN MENU */}
//         <li className="dropdown" ref={dropdownRef}>
//           <div
//             className="icon-link dropdown-toggle"
//             onClick={() => setShowDropdown(!showDropdown)}
//           >
//             <FaRegUser className="icon" />
//             <span>{userId ? "Account" : "Login"}</span>
//           </div>

//           {showDropdown && (
//             <div className="dropdown-menu">
//               {!userId && (
//                 <Link to="/user-login" className="dropdown-item">
//                   <FaRegUser className="dropdown-icon" /> Login
//                 </Link>
//               )}

//               {userId && (
//                 <>
//                   <Link to="/user-profile" className="dropdown-item">
//                     <FaUserCircle className="dropdown-icon" /> My Profile
//                   </Link>

//                   <button
//                     className="dropdown-item logout-btn"
//                     onClick={() => setShowLogoutPopup(true)}
//                   >
//                     <FaSignOutAlt className="dropdown-icon" /> Logout
//                   </button>
//                 </>
//               )}
//             </div>
//           )}
//         </li>

//         {/* CART */}
//         <li>
//           <Link to="/orders/cart" className="icon-link">
//             <IoCartOutline className="icon" />
//             <span>Cart</span>
//             {cartCount > 0 && <span className="cart-badge">{cartCount}</span>}
//           </Link>
//         </li>

//         <li>
//           <Link to="/adminlogin" className="admin-btn">Admin</Link>
//         </li>
//       </ul>

//       {/* LOGOUT POPUP */}
//       {showLogoutPopup && (
//         <div className="logout-overlay">
//           <div className="logout-box">
//             <h3>Logout?</h3>
//             <p>Are you sure you want to logout?</p>

//             <div className="logout-buttons">
//               <button className="logout-cancel" onClick={handleCancelLogout}>
//                 Cancel
//               </button>

//               <button className="logout-ok" onClick={handleConfirmLogout}>
//                 OK
//               </button>
//             </div>
//           </div>
//         </div>
//       )}
//     </nav>
//   );
// };

// export default Navbar;






import { Link, useNavigate } from "react-router-dom";
import { useState, useEffect, useRef } from "react";
import { IoCartOutline } from "react-icons/io5";
import { FaRegUser, FaUserCircle, FaSignOutAlt } from "react-icons/fa";
import "./Navbar.css";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMagnifyingGlass } from "@fortawesome/free-solid-svg-icons";


const Navbar = () => {
  const [cartCount, setCartCount] = useState(0);
  const [showDropdown, setShowDropdown] = useState(false);
  const [showLogoutPopup, setShowLogoutPopup] = useState(false);
  const dropdownRef = useRef(null);
  const navigate = useNavigate();

  const userId = localStorage.getItem("user_id");

  useEffect(() => {
    loadUserCart();
    window.addEventListener("storage", loadUserCart);
    return () => window.removeEventListener("storage", loadUserCart);
  }, [userId]);

  const loadUserCart = () => {
    if (!userId) return setCartCount(0);

    const cart = JSON.parse(localStorage.getItem(`cart_${userId}`)) || [];
    setCartCount(cart.length);
  };

  // ✅ FIXED LOGOUT — DO NOT DELETE CART DATA
  const handleConfirmLogout = () => {
    // ❌ REMOVE THIS — Do not delete user's saved cart
    // localStorage.removeItem(`cart_${userId}`);

    // Remove only login session
    localStorage.removeItem("user_id");

    // UI should show empty cart
    setCartCount(0);

    setShowLogoutPopup(false);
    navigate("/user-login");
  };

  const handleCancelLogout = () => {
    setShowLogoutPopup(false);
  };

  return (
    <nav className="navbar">
      <div className="navbar-logo">
        <Link to="/">🌿 Herbal Store</Link>
      </div>

      {/* 🔍 SEARCH BAR */}
      <div className="navbar-search">
        <div className="search-box">
          <input
            type="text"
            placeholder="search for products and more"
            className="search-input"
            onKeyDown={(e) => {
              if (e.key === "Enter") {
                navigate(`/products?search=${e.target.value}`);
              }
            }}
          />

          <span
            className="search-icon"
            onClick={() => {
              const value = document.querySelector(".search-input").value;
              navigate(`/products?search=${value}`);
            }}
          >
            <FontAwesomeIcon icon={faMagnifyingGlass} />
          </span>

        </div>
      </div>



      <ul className="navbar-links">
        <li><Link to="/">Home</Link></li>
        <li><Link to="/about">About</Link></li>

        <li className="dropdown" ref={dropdownRef}>
          <div
            className="icon-link dropdown-toggle"
            onClick={() => setShowDropdown(!showDropdown)}
          >
            <FaRegUser className="icon" />
            <span>{userId ? "Account" : "Login"}</span>
          </div>

          {showDropdown && (
            <div className="dropdown-menu">
              {!userId && (
                <Link to="/user-login" className="dropdown-item">
                  <FaRegUser className="dropdown-icon" /> Login
                </Link>
              )}

              {userId && (
                <>
                  <Link to="/user-profile" className="dropdown-item">
                    <FaUserCircle className="dropdown-icon" /> My Profile
                  </Link>
                  <Link to="/orders/myorders" className="dropdown-item">
                    📦 My Orders
                  </Link>
                  <button
                    className="dropdown-item logout-btn"
                    onClick={() => setShowLogoutPopup(true)}
                  >
                    <FaSignOutAlt className="dropdown-icon" /> Logout
                  </button>
                </>
              )}
            </div>
          )}
        </li>

        <li>
          <Link to="/orders/cart" className="icon-link">
            <IoCartOutline className="icon" />
            <span>Cart</span>
            {cartCount > 0 && <span className="cart-badge">{cartCount}</span>}
          </Link>
        </li>

        <li>
          <Link to="/adminlogin" className="admin-btn">Admin</Link>
        </li>
      </ul>

      {/* LOGOUT POPUP */}
      {showLogoutPopup && (
        <div className="logout-overlay">
          <div className="logout-box">
            <h3>Logout?</h3>
            <p>Are you sure you want to logout?</p>
            <div className="logout-buttons">
              <button className="logout-cancel" onClick={handleCancelLogout}>
                Cancel
              </button>
              <button className="logout-ok" onClick={handleConfirmLogout}>
                OK
              </button>
            </div>
          </div>
        </div>
      )}
    </nav>

  );
};

export default Navbar;

