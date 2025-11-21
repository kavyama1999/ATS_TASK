// import React, { useState } from "react";
// import api from "../api/axios";
// import "./ForgotPassword.css";

// const ForgotPassword = () => {
//   const [email, setEmail] = useState("");
//   const [message, setMessage] = useState("");

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     setMessage("");

//     try {
//       const res = await api.post("/forgot-password/", { email });
//       setMessage("✔ Password reset OTP sent to your email!");
//     } catch (err) {
//       setMessage("❌ Email not found!");
//     }
//   };

//   return (
//     <div className="fp-container">
//       <div className="fp-card">
//         <h2>Forgot Password</h2>

//         <form onSubmit={handleSubmit}>
//           <input
//             type="email"
//             placeholder="Enter your registered email"
//             value={email}
//             onChange={(e) => setEmail(e.target.value)}
//             required
//           />

//           <button type="submit">Send OTP</button>
//         </form>

//         {message && <p className="fp-msg">{message}</p>}
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
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await api.post("/forgot-password/", { email });
      navigate("/verify-otp", { state: { email } });  // ⭐ PASS EMAIL
    } catch (err) {
      setMessage("❌ Email not found!");
    }
  };

  return (
    <div className="fp-container">
      <div className="fp-card">
        <h2>Forgot Password</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Enter your registered email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <button type="submit">Send OTP</button>
        </form>

        {message && <p className="fp-msg">{message}</p>}
      </div>
    </div>
  );
};

export default ForgotPassword;
