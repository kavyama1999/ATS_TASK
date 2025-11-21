import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./Payment.css";

const Payment = () => {
    const navigate = useNavigate();
    const { state } = useLocation();

    const [method, setMethod] = useState("");
    const [loading, setLoading] = useState(false);  // ✅ for blur animation

    const orderData = state?.orderData;

    const payAndPlaceOrder = async () => {
        if (!method) {
            alert("Please select payment method");
            return;
        }

        if (loading) return; // avoid duplicate clicks

        setLoading(true); // 🔥 blur button & show loading

        const payload = {
            ...orderData,
            payment_method: method,
        };

        try {
            const res = await fetch("http://localhost:8000/orders/", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(payload),
            });

            const data = await res.json();
            const orderId = data.id || data.orderId || data.order_id;

            setTimeout(() => {
                navigate("/orders/ordersuccess", { state: { orderId } });
            }, 800);

        } catch (err) {
            alert("Payment failed. Try again.");
            setLoading(false);
        }
    };

    return (
        <div className="payment-container">
            <div className="payment-card">
                <h2>Select Payment Method</h2>

                <div className="amount-box">
                    <h3>₹ {orderData.total_price}</h3>
                </div>

                <label className="pm-option">
                    <input
                        type="radio"
                        className="big-radio"
                        name="pm"
                        value="COD"
                        onChange={(e) => setMethod(e.target.value)}
                    />
                    Cash on Delivery
                </label>

                <label className="pm-option">
                    <input
                        type="radio"
                        className="big-radio"
                        name="pm"
                        value="UPI"
                        onChange={(e) => setMethod(e.target.value)}
                    />
                    UPI / Google Pay / PhonePe
                </label>

                <label className="pm-option">
                    <input
                        type="radio"
                        className="big-radio"
                        name="pm"
                        value="CARD"
                        onChange={(e) => setMethod(e.target.value)}
                    />
                    Credit / Debit Card
                </label>

                <button
                    className={`payment-btn ${loading ? "blur-btn" : ""}`}
                    onClick={payAndPlaceOrder}
                    disabled={loading}
                >
                    {loading ? "Processing…" : "Pay & Confirm Order"}
                </button>
            </div>
        </div>
    );
};

export default Payment;
