

// import React, { useState } from "react";
// import { useNavigate, useLocation } from "react-router-dom";
// import api from "../api/axios";
// import "./ForgotPassword.css";

// const VerifyOTP = () => {
//   const navigate = useNavigate();
//   const { state } = useLocation();
//   const email = state?.email;

//   const [otp, setOtp] = useState("");
//   const [message, setMessage] = useState("");
//   const [loading, setLoading] = useState(false);
//   const [resendLoading, setResendLoading] = useState(false);

//   const handleVerify = async (e) => {
//     e.preventDefault();
//     setLoading(true);
//     setMessage("");

//     try {
//       await api.post("/verify-otp/", { email, otp: Number(otp) });
//       navigate("/reset-password", { state: { email } });
//     } catch (err) {
//       setMessage("❌ Invalid OTP");
//       setLoading(false);
//     }
//   };

//   // ✅ Resend OTP
//   const handleResend = async () => {
//     setResendLoading(true);
//     setMessage("");
//     try {
//       await api.post("/forgot-password/", { email });
//       setMessage("✔ OTP resent successfully!");
//     } catch (err) {
//       setMessage("❌ Failed to resend OTP!");
//     } finally {
//       setResendLoading(false);
//     }
//   };

//   return (
//     <div className="fp-container">
//       <div className="fp-card">
//         <h2>Verify OTP</h2>
//         <p><b>Email: </b>{email}</p>

//         <form onSubmit={handleVerify}>
//           <input
//             type="text"
//             placeholder="Enter OTP"
//             value={otp}
//             onChange={(e) => setOtp(e.target.value)}
//             required
//           />

//           <button type="submit" disabled={loading} style={{ opacity: loading ? 0.5 : 1 }}>
//             {loading ? "Verifying..." : "Verify OTP"}
//           </button>
//         </form>

//         <button
//           onClick={handleResend}
//           disabled={resendLoading}
//           style={{ marginTop: "10px", background: "#2e7d32", color: "#fff", cursor: resendLoading ? "not-allowed" : "pointer" }}
//         >
//           {resendLoading ? "Resending..." : "Resend OTP"}
//         </button>

//         {message && <p className="fp-msg">{message}</p>}
//       </div>
//     </div>
//   );
// };

// export default VerifyOTP;


import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import api from "../api/axios";
import "./VerifyOTP.css"; // new CSS for professional UI

const VerifyOTP = () => {
  const navigate = useNavigate();
  const { state } = useLocation();
  const email = state?.email;

  const [otp, setOtp] = useState("");
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);
  const [resendLoading, setResendLoading] = useState(false);
  const [msgColor, setMsgColor] = useState("green"); // ✅ green for success, red for error

  const handleVerify = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage("");

    try {
      await api.post("/verify-otp/", { email, otp: Number(otp) });
      navigate("/reset-password", { state: { email } });
    } catch (err) {
      setMessage("❌ Invalid OTP");
      setMsgColor("red");
      setLoading(false);
    }
  };

  const handleResend = async () => {
    setResendLoading(true);
    setMessage("");
    try {
      await api.post("/forgot-password/", { email });
      setMessage("✔ OTP resent successfully!");
      setMsgColor("green"); // ✅ success message in green
    } catch (err) {
      setMessage("❌ Failed to resend OTP!");
      setMsgColor("red");
    } finally {
      setResendLoading(false);
    }
  };

  return (
    <div className="otp-container">
      <div className="otp-card">
        <h2>🔐 Verify OTP</h2>
        <p className="otp-email">Email: <b>{email}</b></p>

        <form onSubmit={handleVerify} className="otp-form">
          <input
            type="text"
            placeholder="Enter OTP"
            value={otp}
            onChange={(e) => setOtp(e.target.value)}
            required
            maxLength={6}
          />

          <button
            type="submit"
            disabled={loading}
            className="btn-primary"
          >
            {loading ? "Verifying..." : "Verify OTP"}
          </button>
        </form>

        <button
          onClick={handleResend}
          disabled={resendLoading}
          className="btn-secondary"
        >
          {resendLoading ? "Resending..." : "Resend OTP"}
        </button>

        {message && (
          <p
            className="otp-message"
            style={{ color: msgColor }}
          >
            {message}
          </p>
        )}
      </div>
    </div>
  );
};

export default VerifyOTP;
