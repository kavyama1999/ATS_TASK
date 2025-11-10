

// import { Link } from "react-router-dom";
// import "./Navbar.css"; // 🔥 import the CSS file

// const Navbar = () => {
//   return (
//     <nav className="navbar">
//       <div className="navbar-logo">🌿 Herbal Store</div>

//       <ul className="navbar-links">
//         <li><a href="/admin">Admin</a></li>

//         <li><Link to="/">Home</Link></li>
//         <li><Link to="/products">Products</Link></li>
//         <li><Link to="/about">About</Link></li>
//         <li>
//           <Link to="/adminlogin" className="admin-btn">
//             Admin
//           </Link>
//         </li>
//         {/* <li><Link to="/contact">Contact</Link></li> */}
//       </ul>
//     </nav>
//   );
// };

// export default Navbar;


import { Link } from "react-router-dom";
import "./Navbar.css"; // 🔥 import the CSS file

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-logo">🌿 Herbal Store</div>

      <ul className="navbar-links">
        <li><Link to="/">Home</Link></li>
        <li><Link to="/products">Products</Link></li>
        <li><Link to="/about">About</Link></li>

        {/* ✅ Admin Button */}
        <li>
          <Link to="/adminlogin" className="admin-btn">
            Admin
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
