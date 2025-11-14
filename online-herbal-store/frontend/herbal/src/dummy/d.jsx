/* Layout */
.admin-layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  background: #f3fff3;
}

/* 🌿 Header */
.admin-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: #0d5b2d;
  color: white;
  padding: 12px 25px;
  height: 70px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  box-shadow: 0 2px 8px rgba(0,0,0,0.18);
}

/* 🌿 Header Title */
.header-title {
  font-size: 1.7rem;
  font-weight: 700;
  text-align: center;
  flex: 1;
  margin: 0;
}

/* 🌿 Header Icon Buttons */
.icon-btn {
  background: rgba(255,255,255,0.15);
  border: none;
  width: 42px;
  height: 42px;
  border-radius: 50%;
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: 0.3s;
}

.icon-btn:hover {
  background: rgba(255,255,255,0.28);
  transform: scale(1.08);
}

.logout {
  background: #e53935 !important;
}

.logout:hover {
  background: #c62828 !important;
}

/* 🌿 Sidebar */
.sidebar {
  width: 220px;
  background-color: #0d5b2d;
  color: white;
  padding: 20px;
  position: fixed;
  top: 70px;
  left: 0;
  bottom: 0;
  overflow-y: auto;
}

.sidebar h2 {
  margin-bottom: 20px;
  font-size: 1.4rem;
  font-weight: 700;
}

.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar ul li {
  margin: 14px 0;
}

.sidebar ul li a {
  color: white;
  text-decoration: none;
  font-weight: 600;
  display: block;
  padding: 8px;
  transition: 0.25s;
  border-radius: 6px;
}

.sidebar ul li a:hover {
  background: rgba(255,255,255,0.1);
  color: #b2fab4;
  padding-left: 12px;
}

/* 🌿 Main content */
.main-content {
  margin-left: 220px;
  margin-top: 70px;
  padding: 30px;
  min-height: calc(100vh - 120px);
  background: #f4fff4;
}

/* 🌿 Footer */
.admin-footer {
  background: #0d5b2d;
  color: white;
  text-align: center;
  padding: 10px;
  position: fixed;
  bottom: 0;
  left: 220px;
  right: 0;
}

/* 🌿 Responsive */
@media (max-width: 900px) {
  .sidebar {
    position: relative;
    width: 100%;
  }
  .main-content {
    margin-left: 0;
  }
  .admin-footer {
    left: 0;
    position: relative;
  }
}
