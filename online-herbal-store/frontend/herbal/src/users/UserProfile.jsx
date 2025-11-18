

import React, { useEffect, useState } from "react";
import api from "../api/axios";
import "./UserProfile.css";
import { useNavigate } from "react-router-dom";
import { FiEdit } from "react-icons/fi";

const UserProfile = () => {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();
  const userId = localStorage.getItem("user_id");

  useEffect(() => {
    if (!userId) return;
    fetchUser();
  }, [userId]);

  const fetchUser = async () => {
    try {
      const res = await api.get(`/users/${userId}`);
      setUser(res.data);
    } catch (err) {
      console.error("Error:", err);
    }
  };

  if (!userId) {
    return (
      <div className="profile-container">
        <div className="profile-card">
          <h2>Please Login</h2>
        </div>
      </div>
    );
  }

  if (!user) {
    return (
      <div className="profile-container">
        <div className="profile-card">
          <h2>Loading...</h2>
        </div>
      </div>
    );
  }

  return (
    <div className="profile-container">
      <div className="profile-card glass-effect">
        <button className="edit-button" onClick={() => navigate("/edit-profile")}>
          <FiEdit size={18} /> Edit
        </button>

        <div className="profile-header">
          <img
            src={
              user.profile_image
                ? `http://localhost:8000/static/images/${user.profile_image}`  // 🔥 CHANGED
                : "https://cdn-icons-png.flaticon.com/512/847/847969.png"
            }
            alt="profile"
            className="profile-image"
          />
          <h2 className="user-name">{user.username}</h2>
        </div>

        <div className="profile-info">
          <div className="info-box">
            <span className="label">Email</span>
            <span className="value">{user.email}</span>
          </div>

          <div className="info-box">
            <span className="label">Address</span>
            <span className="value">{user.address || "No address"}</span>
          </div>

          <div className="info-box">
            <span className="label">Contact Number</span>
            <span className="value">{user.contact_number || "Not added"}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserProfile;
