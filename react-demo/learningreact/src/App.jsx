// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'

// import { useEffect, useState } from 'react'
// import api from "./api"; // ✅ add this line


// function App() {
//   const [count, setCount] = useState(0)

//     const [users, setUsers] = useState([]); // ✅ add this line


//   return (
//     <>
//       <div>
//         <a href="https://vite.dev" target="_blank">
//           <img src={viteLogo} className="logo" alt="Vite logo" />
//         </a>
//         <a href="https://react.dev" target="_blank">
//           <img src={reactLogo} className="logo react" alt="React logo" />
//         </a>
//       </div>
//       <h1>Vite + React</h1>
//       <h2>Kavya</h2>
//       <div className="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/App.jsx</code> and save to test HMR
//         </p>
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//     </>
//   )
// }

// export default App


import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import api from "./api"; // ✅ Axios instance to connect FastAPI

function App() {
  // ✅ React states
  const [count, setCount] = useState(0);
  const [users, setUsers] = useState([]); // store users fetched from FastAPI

  // ✅ Fetch users from FastAPI when the page loads
  useEffect(() => {
    api.get("/users/")
      .then((res) => {
        console.log("Fetched users:", res.data);
        setUsers(res.data);
      })
      .catch((err) => {
        console.error("Error fetching users:", err);
      });
  }, []);

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>

      <h1>Vite + React</h1>
      <h2>Kavya User Table</h2>

      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>

      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>

      {/* ✅ FastAPI Users Section */}
      <div style={{ marginTop: "30px", textAlign: "left" }}>
        <h2>Users from FastAPI</h2>

        {users.length === 0 ? (
          <p>No users found.</p>
        ) : (
          <ul>
            {users.map((u) => (
              <li key={u.id}>
                <strong>{u.name}</strong> — {u.email}
              </li>
            ))}
          </ul>
        )}
      </div>
    </>
  );
}

export default App;
