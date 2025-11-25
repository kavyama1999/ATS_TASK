
// import React, { useState } from "react";
// import { useLocation, useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./ForgotPassword.css";

// const ResetPassword = () => {
//   const { state } = useLocation();
//   const navigate = useNavigate();
//   const email = state?.email;

//   const [password, setPassword] = useState("");
//   const [message, setMessage] = useState("");
//   const [loading, setLoading] = useState(false); // ⭐ ADDED

//   const handleReset = async (e) => {
//     e.preventDefault();
//     setLoading(true);

//     try {
//       await api.post("/reset-password/", {
//         email,
//         new_password: password
//       });

//       setMessage("✔ Your password reset successfully! Redirecting...");
//       setTimeout(() => navigate("/user-login"), 2000);

//     } catch (err) {
//       setMessage("❌ Failed to reset password!");
//       setLoading(false);
//     }
//   };

//   return (
//     <div className="fp-container">
//       <div className="fp-card">
//         <h2>Reset Password</h2>

//         <p><b>Email:</b> {email}</p>

//         <form onSubmit={handleReset}>
//           <input
//             type="password"
//             placeholder="Enter new password"
//             value={password}
//             onChange={(e) => setPassword(e.target.value)}
//             required
//           />

//           <button type="submit" disabled={loading} style={{ opacity: loading ? 0.5 : 1 }}>
//             {loading ? "Updating..." : "Reset Password"}
//           </button>
//         </form>

//         {message && <p className="fp-msg">{message}</p>}
//       </div>
//     </div>
//   );
// };

// export default ResetPassword;

import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import api from "../api/axios";
import "./ForgotPassword.css";

const ResetPassword = () => {
  const { state } = useLocation();
  const navigate = useNavigate();
  const email = state?.email;

  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);

  const handleReset = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage("");

    try {
      await api.post("/reset-password/", {
        email,
        new_password: password,
      });

      setMessage("✔ Your password reset successfully!");
      setTimeout(() => navigate("/user-login"), 2000);
    } catch (err) {
      setMessage("❌ Failed to reset password!");
      setLoading(false);
    }
  };

  return (
    <div className="fp-container">

      {/* ⭐ TOP-RIGHT TOAST MESSAGE ⭐ */}
      {message && (
        <div
          className={`toast-message ${
            message.includes("Failed") ? "toast-error" : ""
          }`}
        >
          {message}
        </div>
      )}

      <div className="fp-card">
        <h2>Reset Password</h2>

        <p><b>Email:</b> {email}</p>

        <form onSubmit={handleReset}>
          <input
            type="password"
            placeholder="Enter new password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            disabled={loading}
          />

          <button type="submit" disabled={loading}>
            {loading ? "Updating..." : "Reset Password"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default ResetPassword;
