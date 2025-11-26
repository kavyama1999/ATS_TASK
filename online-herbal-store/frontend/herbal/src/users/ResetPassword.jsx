
// import React, { useState } from "react";
// import { useLocation, useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./ForgotPassword.css";

// const ResetPassword = () => {
//   const { state } = useLocation();
//   const navigate = useNavigate();
//   const email = state?.email;

//   const [password, setPassword] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const [message, setMessage] = useState("");
//   const [loading, setLoading] = useState(false);

//   // ✅ Password strength check
//   const validatePassword = (pw) => {
//     return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(pw);
//   };

//   const handleChange = (e) => {
//     setPassword(e.target.value);

//     if (!validatePassword(e.target.value)) {
//       setPasswordError("❌ Please enter a strong password");
//     } else {
//       setPasswordError("");
//     }
//   };

//   const handleReset = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     if (passwordError || !validatePassword(password)) {
//       setPasswordError("❌ Please enter a strong password");
//       return;
//     }

//     setLoading(true);
//     try {
//       await api.post("/reset-password/", {
//         email,
//         new_password: password,
//       });

//       setMessage("✔ Your password reset successfully!");
//       setTimeout(() => navigate("/user-login"), 2000);
//     } catch (err) {
//       setMessage("❌ Failed to reset password!");
//       setLoading(false);
//     }
//   };

//   return (
//     <div className="fp-container">
//       {message && (
//         <div className={`toast-message ${message.includes("Failed") ? "toast-error" : ""}`}>
//           {message}
//         </div>
//       )}

//       <div className="fp-card">
//         <h2>Reset Password</h2>
//         <p><b>Email:</b> {email}</p>

//         <form onSubmit={handleReset}>
//           <input
//             type="password"
//             placeholder="Enter new password"
//             value={password}
//             onChange={handleChange}
//             required
//             disabled={loading}
//           />
//           {passwordError && (
//             <p style={{ color: "red", fontSize: "0.9rem" }}>{passwordError}</p>
//           )}

//           <button type="submit" disabled={loading}>
//             {loading ? "Updating..." : "Reset Password"}
//           </button>
//         </form>
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
  const [passwordError, setPasswordError] = useState("");
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);

  const validatePassword = (pw) => {
    return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{6,}$/.test(pw);
  };

  const handleChange = (e) => {
    setPassword(e.target.value);

    if (!validatePassword(e.target.value)) {
      setPasswordError("❌ Please enter a strong password");
    } else {
      setPasswordError("");
    }
  };

  const handleReset = async (e) => {
    e.preventDefault();
    setMessage("");

    if (passwordError || !validatePassword(password)) {
      setPasswordError("❌ Please enter a strong password");
      return;
    }

    setLoading(true);
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
      <div className="fp-card">

        {/* ⭐ Message INSIDE card above input */}
        {message && (
          <div
            className={`inline-error ${
              message.includes("Failed") ? "inline-error-red" : "inline-success"
            }`}
          >
            {message}
          </div>
        )}

        <h2>Reset Password</h2>
        <p><b>Email:</b> {email}</p>

        <form onSubmit={handleReset}>
          <input
            type="password"
            placeholder="Enter new password"
            value={password}
            onChange={handleChange}
            required
            disabled={loading}
          />

          {passwordError && (
            <p className="inline-error-red" style={{ marginTop: "-5px" }}>
              {passwordError}
            </p>
          )}

          <button type="submit" disabled={loading}>
            {loading ? "Updating..." : "Reset Password"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default ResetPassword;
