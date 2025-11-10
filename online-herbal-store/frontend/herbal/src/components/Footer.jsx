import React from "react";

const Footer = () => {
  return (
    <footer className="bg-green-700 text-white text-center py-6 mt-10">
      <p className="text-lg font-semibold">
        🌿 <b>Thank you for visiting Online Herbal Store</b>
      </p>
      <p className="mt-2">
      <b> © {new Date().getFullYear()} All Rights Reserved</b>
      </p>

      {/* <div className="flex justify-center space-x-6 mt-3 text-xl">
        <a href="#" className="hover:text-yellow-300 transition">📘</a>
        <a href="#" className="hover:text-yellow-300 transition">📷</a>
        <a href="#" className="hover:text-yellow-300 transition">💬</a>
      </div> */}
    </footer>
  );
};

export default Footer;
