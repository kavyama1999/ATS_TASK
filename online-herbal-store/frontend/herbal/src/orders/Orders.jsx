import React, { useEffect, useState } from "react";
import api from "../api/axios";

const Orders = () => {
  const [orders, setOrders] = useState([]);
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await api.get("/orders/");
      setOrders(response.data);
    } catch (error) {
      console.error("Error fetching orders:", error);
    }
  };

  const createOrder = async () => {
    try {
      const orderData = {
        user_id: 1, // 👈 Change this to an existing user ID
        total_price: 500,
        items: [
          { product_id: 1, quantity: 2, price: 250 },
          { product_id: 3, quantity: 1, price: 250 },
        ],
      };

      const response = await api.post("/orders/", orderData);
      setMessage(`✅ Order #${response.data.id} created successfully`);
      fetchOrders();
    } catch (error) {
      console.error("Error creating order:", error);
      setMessage("❌ Failed to create order");
    }
  };

  return (
    <div className="p-6">
      <h2 className="text-2xl font-semibold text-green-700 mb-4">📦 Orders</h2>
      <button
        onClick={createOrder}
        className="bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700"
      >
        Create Dummy Order
      </button>
      {message && <p className="mt-3 text-gray-700">{message}</p>}

      <table className="min-w-full border mt-6 border-gray-300 rounded-lg">
        <thead className="bg-green-200">
          <tr>
            <th className="py-2 px-4 border">Order ID</th>
            <th className="py-2 px-4 border">User ID</th>
            <th className="py-2 px-4 border">Total Price</th>
            <th className="py-2 px-4 border">Order Date</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((o) => (
            <tr key={o.id} className="text-center border-b">
              <td className="py-2 border">{o.id}</td>
              <td className="py-2 border">{o.user_id}</td>
              <td className="py-2 border">₹{o.total_price}</td>
              <td className="py-2 border">{o.order_date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Orders;
