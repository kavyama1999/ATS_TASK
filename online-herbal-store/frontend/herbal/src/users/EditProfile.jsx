


import React, { useEffect, useState } from "react";
import api from "../api/axios";
import "./EditProfile.css";
import { useNavigate } from "react-router-dom";

const EditProfile = () => {
  const userId = localStorage.getItem("user_id");
  const navigate = useNavigate();

  const [darkMode, setDarkMode] = useState(false);
  const [loading, setLoading] = useState(true);

  const [profilePic, setProfilePic] = useState(null);
  const [previewPic, setPreviewPic] = useState(null);

  const [form, setForm] = useState({
    username: "",
    email: "",
    address: "",
    contact_number: "",
    profile_image: "",
  });

  // Fetch user data
  useEffect(() => {
    api.get(`/users/${userId}`)
      .then((res) => {
        setForm(res.data);

        if (res.data.profile_image) {
          setPreviewPic(
            `http://localhost:8000/static/images/${res.data.profile_image}` // 🔥 CHANGED
          );
        }

        setTimeout(() => setLoading(false), 700);
      })
      .catch((err) => console.error(err));
  }, [userId]);

  // Handle file change
  const handleProfilePic = (e) => {
    const file = e.target.files[0];
    setProfilePic(file);
    setPreviewPic(URL.createObjectURL(file));
  };

  // Save changes
  const handleSave = async () => {
    try {
      const formData = new FormData();
      formData.append("username", form.username);
      formData.append("email", form.email);
      formData.append("address", form.address);
      formData.append("contact_number", form.contact_number);

      if (profilePic) {
        formData.append("profile_image", profilePic);
      }

      await api.put(`/users/${userId}`, formData, {
        headers: { "Content-Type": "multipart/form-data" },
      });

      alert("Profile updated successfully!");
      navigate("/user-profile");
    } catch (error) {
      console.error(error);
      alert("Failed to update profile");
    }
  };

  return (
    <div className={darkMode ? "edit-container dark" : "edit-container"}>
      <div className="dark-toggle">
        <label className="switch">
          <input type="checkbox" checked={darkMode} onChange={() => setDarkMode(!darkMode)} />
          <span className="slider"></span>
        </label>
      </div>

      <h1 className="animated-title">Edit Profile</h1>

      {loading ? (
        <div className="skeleton-wrapper">
          <div className="skeleton avatar"></div>
          <div className="skeleton line"></div>
          <div className="skeleton line small"></div>
        </div>
      ) : (
        <div className="profile-card">
          <div className="profile-pic-section">
            <img
              src={previewPic || "https://via.placeholder.com/120"}
              alt="Profile"
              className="profile-pic"
            />

            <label className="upload-btn">
              Upload Photo
              <input type="file" hidden onChange={handleProfilePic} />
            </label>
          </div>

          <div className="form-section">
            <label>Username</label>
            <input
              type="text"
              value={form.username}
              onChange={(e) => setForm({ ...form, username: e.target.value })}
            />

            <label>Email</label>
            <input
              type="email"
              value={form.email}
              onChange={(e) => setForm({ ...form, email: e.target.value })}
            />

            <label>Address</label>
            <input
              type="text"
              value={form.address}
              onChange={(e) => setForm({ ...form, address: e.target.value })}
            />

            <label>Contact Number</label>
            <input
              type="text"
              value={form.contact_number || ""}
              maxLength={10}
              onChange={(e) => setForm({ ...form, contact_number: e.target.value })}
            />

            <button className="save-btn" onClick={handleSave}>
              Save Changes
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default EditProfile;
