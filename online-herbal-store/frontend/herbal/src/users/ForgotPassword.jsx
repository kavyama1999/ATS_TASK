


// import React, { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import api from "../api/axios";
// import "./ForgotPassword.css";

// const ForgotPassword = () => {
//   const [email, setEmail] = useState("");
//   const [message, setMessage] = useState("");
//   const [loading, setLoading] = useState(false);
//   const navigate = useNavigate();

//   // ✅ validate lowercase only
//   const isLowerCase = (str) => str === str.toLowerCase();

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     // ❌ block if not lowercase
//     if (!isLowerCase(email)) {
//       setMessage("❌ Invalid  Email ");
//       return;
//     }

//     setLoading(true);
//     try {
//       await api.post("/forgot-password/", { email }); // send as-is (lowercase)
//       navigate("/verify-otp", { state: { email } });
//     } catch (err) {
//       setMessage("❌ Email not found! Please enter exactly as registered.");
//       setLoading(false);
//     }
//   };

//   return (
//     <div className="fp-container">
//       {message && (
//         <div className={`toast-message ${message.includes("❌") ? "toast-error" : ""}`}>
//           {message}
//         </div>
//       )}

//       <div className="fp-card">
//         <h2>Forgot Password</h2>

//         <form onSubmit={handleSubmit}>
//           <input
//             type="email"
//             placeholder="Enter your registered email (lowercase only)"
//             value={email}
//             onChange={(e) => setEmail(e.target.value)}
//             required
//             disabled={loading}
//           />

//           <button type="submit" disabled={loading}>
//             {loading ? "Sending..." : "Send OTP"}
//           </button>
//         </form>
//       </div>
//     </div>
//   );
// };

// export default ForgotPassword;
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";
import "./ForgotPassword.css";

const ForgotPassword = () => {
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const isLowerCase = (str) => str === str.toLowerCase();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");

    if (!isLowerCase(email)) {
      setMessage("❌ Invalid Email ");
      return;
    }

    setLoading(true);
    try {
      await api.post("/forgot-password/", { email });
      navigate("/verify-otp", { state: { email } });
    } catch (err) {
      setMessage("❌ Email not found! Please enter exactly as registered.");
      setLoading(false);
    }
  };

  return (
    <div className="fp-container">
      <div className="fp-card">

        {/* ⭐ Error message INSIDE card above input */}
        {message && (
          <div className={`inline-error ${message.includes("❌") ? "inline-error-red" : ""}`}>
            {message}
          </div>
        )}

        <h2>Forgot Password</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Enter your registered email (lowercase only)"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            disabled={loading}
          />

          <button type="submit" disabled={loading}>
            {loading ? "Sending..." : "Send OTP"}
          </button>
        </form>
      </div>
    </div>
  );
};

export default ForgotPassword;
