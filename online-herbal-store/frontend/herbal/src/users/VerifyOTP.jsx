


import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import api from "../api/axios";
import "./ForgotPassword.css";

const VerifyOTP = () => {
  const navigate = useNavigate();
  const { state } = useLocation();
  const email = state?.email;

  const [otp, setOtp] = useState("");
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false); // ⭐ ADDED

  const handleVerify = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      await api.post("/verify-otp/", {
        email,
        otp: Number(otp)
      });

      navigate("/reset-password", { state: { email } });
    } catch (err) {
      setMessage("❌ Invalid OTP");
      setLoading(false);
    }
  };

  return (
    <div className="fp-container">
      <div className="fp-card">
        <h2>Verify OTP</h2>

        <p><b>Email: </b>{email}</p>

        <form onSubmit={handleVerify}>
          <input
            type="text"
            placeholder="Enter OTP"
            value={otp}
            onChange={(e) => setOtp(e.target.value)}
            required
          />

          <button type="submit" disabled={loading} style={{ opacity: loading ? 0.5 : 1 }}>
            {loading ? "Verifying..." : "Verify OTP"}
          </button>
        </form>

        {message && <p className="fp-msg">{message}</p>}
      </div>
    </div>
  );
};

export default VerifyOTP;
