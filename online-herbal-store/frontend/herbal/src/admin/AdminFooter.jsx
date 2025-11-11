import React from "react";

const AdminFooter = () => {
  return (
    <footer className="bg-green-700 text-white text-center py-3 mt-auto shadow-inner">
      <p className="text-sm">&copy; {new Date().getFullYear()} Herbal Store Admin Dashboard. All rights reserved.</p>
    </footer>
  );
};

export default AdminFooter;
