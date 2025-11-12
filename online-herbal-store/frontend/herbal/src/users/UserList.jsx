// import React, { useEffect, useState } from "react";
// import api from "../api/axios";

// const UserList = () => {
//   const [users, setUsers] = useState([]);

//   useEffect(() => {
//     fetchUsers();
//   }, []);

//   const fetchUsers = async () => {
//     try {
//       const response = await api.get("/users/");
//       setUsers(response.data);
//     } catch (error) {
//       console.error("Error fetching users:", error);
//     }
//   };

//   return (
//     <div className="p-6">
//       <h2 className="text-2xl font-semibold text-green-700 mb-4">👥 Users</h2>
//       <table className="min-w-full border border-gray-300 rounded-lg">
//         <thead className="bg-green-200">
//           <tr>
//             <th className="py-2 px-4 border">ID</th>
//             <th className="py-2 px-4 border">Username</th>
//             <th className="py-2 px-4 border">Email</th>
//           </tr>
//         </thead>
//         <tbody>
//           {users.map((u) => (
//             <tr key={u.id} className="text-center border-b">
//               <td className="py-2 border">{u.id}</td>
//               <td className="py-2 border">{u.username}</td>
//               <td className="py-2 border">{u.email}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// };

// export default UserList;

import React, { useEffect, useState } from "react";
import api from "../api/axios";
import "./UserList.css"; // External CSS file

const UserList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await api.get("/users/");
      setUsers(response.data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  return (
    <div className="userlist-container">
      <div className="userlist-card">
        <header className="userlist-header">
          <h2>🌿  Herbal Store — User Management</h2>
          <span className="user-count">Total Users: {users.length}</span>
        </header>

        <table className="userlist-table">
          <thead>
            <tr>
              <th>SI No</th>
              <th>ID</th>
              <th>Username</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            {users.length > 0 ? (
              users.map((u, index) => (
                <tr key={u.id}>
                  <td>{index + 1}</td>
                  <td>{u.id}</td>
                  <td>{u.username}</td>
                  <td>{u.email}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="4" className="no-data">
                  No users found
                </td>
              </tr>
            )}
          </tbody>
        </table>

        <footer className="userlist-footer">
          🌱  Herbal Store 🌱
        </footer>
      </div>
    </div>
  );
};

export default UserList;
