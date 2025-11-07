import { useEffect, useState } from "react";
import api from "../api";
import reactLogo from "../assets/react.svg";
import viteLogo from "/vite.svg";

function Users() {
  const [count, setCount] = useState(0);
  const [users, setUsers] = useState([]);

  useEffect(() => {
    api
      .get("/users/")
      .then((res) => {
        setUsers(res.data);
      })
      .catch((err) => {
        console.error("Error fetching users:", err);
      });
  }, []);

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-white text-black p-8">

      {/* ✅ YOUR HEADING HERE */}
      <h1 className="text-4xl font-bold mb-4 text-blue-700">KAVYA</h1>
      <h2 className="text-2xl font-semibold mb-6 text-gray-700">Users Table</h2>

      {/* Logos */}
      <div className="flex items-center space-x-6 mb-6">
        <a href="https://vite.dev" target="_blank" rel="noreferrer">
          <img src={viteLogo} className="w-16 h-16" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank" rel="noreferrer">
          <img src={reactLogo} className="w-16 h-16" alt="React logo" />
        </a>
      </div>

      {/* Counter */}
      <div className="bg-gray-200 p-6 rounded-2xl shadow-xl mb-6">
        <button
          onClick={() => setCount((count) => count + 1)}
          className="bg-blue-500 hover:bg-blue-600 px-6 py-2 rounded-lg text-white transition"
        >
          count is {count}
        </button>
      </div>

      {/* Users Table */}
      <div className="mt-10 w-full flex flex-col items-center">
        <h2 className="text-2xl font-bold mb-4 text-blue-600">
          Users from FastAPI
        </h2>

        {users.length === 0 ? (
          <p className="text-gray-500">No users found.</p>
        ) : (
          <div className="overflow-x-auto w-11/12 md:w-3/4 bg-white shadow-2xl rounded-2xl border border-gray-300">
            <table className="min-w-full text-left border-separate border-spacing-x-4 border-spacing-y-2">
              <thead className="bg-gray-100 text-blue-700 uppercase text-sm">
                <tr>
                  <th className="px-4 py-3 border-b border-gray-400">ID</th>
                  <th className="px-4 py-3 border-b border-gray-400">Name</th>
                  <th className="px-4 py-3 border-b border-gray-400">Email</th>
                </tr>
              </thead>
              <tbody>
                {users.map((user, index) => (
                  <tr
                    key={user.id}
                    className={`${index % 2 === 0 ? "bg-gray-100" : "bg-gray-200"}`}
                  >
                    <td className="px-4 py-3 border border-gray-300">{user.id}</td>
                    <td className="px-4 py-3 border border-gray-300">{user.name}</td>
                    <td className="px-4 py-3 border border-gray-300">{user.email}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}

export default Users;
