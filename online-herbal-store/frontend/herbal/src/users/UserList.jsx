
import React, { useEffect, useState } from "react";
import api from "../api/axios";
import "./UserList.css";

const UserList = () => {
  const [users, setUsers] = useState([]);

  const BASE_URL = "http://localhost:8000"; // ⭐ Your FastAPI URL

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

  // ⭐ Function to handle full image URL
  const getImageUrl = (user) => {
    const img = user.image_url || user.image; // support both
    if (!img) return null;

    // If already full URL (http/https)
    if (img.startsWith("http")) return img;

    // If server returns "/uploads/img.png"
    return `${BASE_URL}${img}`;
  };

  return (
    <div className="userlist-container">
      <div className="userlist-card">
        <header className="userlist-header">
          <h2>🌿 Herbal Store — User Management</h2>
          <span className="user-count">Total Users: {users.length}</span>
        </header>

        <table className="userlist-table">
          <thead>
            <tr>
              <th>SI.NO</th>
              <th>ID</th>
              <th>Image</th>
              <th>Username</th>
              <th>Email</th>
              <th>Contact</th>
              <th>Address</th>
            </tr>
          </thead>

          <tbody>
            {users.length > 0 ? (
              users.map((user,index) => (
                <tr key={user.id}>
            <td>{index + 1}</td>

                  <td>{user.id}</td>


                  {/* Image Column */}
                  <td>
                    {getImageUrl(user) ? (
                      <img
                        src={getImageUrl(user)}
                        alt="User"
                        className="userlist-img"
                      />
                    ) : (
                      <span className="no-img">No Image</span>
                    )}
                  </td>

                  <td>{user.username}</td>
                  <td>{user.email}</td>
                  <td>{user.contact_number}</td>
                  <td>{user.address}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="6" className="no-data">
                  No Users Found
                </td>
              </tr>
            )}
          </tbody>
        </table>

        <footer className="userlist-footer">🌱 Herbal Store 🌱</footer>
      </div>
    </div>
  );
};

export default UserList;
