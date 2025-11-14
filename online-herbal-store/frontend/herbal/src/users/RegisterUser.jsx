

// import React, { useState } from "react";
// import { Link } from "react-router-dom";
// import api from "../api/axios";
// import "./RegisterUser.css";

// const RegisterUser = () => {
//   const [form, setForm] = useState({
//     username: "",
//     email: "",
//     password: "",
//     address: "",
//     contact_number: "",
//   });
//   const [message, setMessage] = useState("");

//   const handleChange = (e) => {
//     setForm({ ...form, [e.target.name]: e.target.value });
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     try {
//       const response = await api.post("/users/", form);
//       setMessage(`✅ User created: ${response.data.username}`);

//       setForm({
//         username: "",
//         email: "",
//         password: "",
//         address: "",
//         contact_number: "",
//       });
//     } catch (error) {
//       console.error("Error creating user:", error);
//       setMessage("❌ User already exists. Please use a different one");
//     }
//   };

//   return (
//     <div className="register-container">
//       <div className="register-card">
//         <h2>👤 Create New User</h2>
//         <form onSubmit={handleSubmit}>
//           <input
//             type="text"
//             name="username"
//             placeholder="Enter Username"
//             value={form.username}
//             onChange={handleChange}
//             required
//           />

//           <input
//             type="email"
//             name="email"
//             placeholder="Enter Email"
//             value={form.email}
//             onChange={handleChange}
//             required
//           />

//           <input
//             type="password"
//             name="password"
//             placeholder="Enter Password"
//             value={form.password}
//             onChange={handleChange}
//             required
//           />

//           {/* NEW FIELDS */}
//           <input
//             type="text"
//             name="address"
//             placeholder="Enter Address"
//             value={form.address}
//             onChange={handleChange}
//             required
//           />

//           <input
//             type="text"
//             name="contact_number"
//             placeholder="Enter Contact Number"
//             value={form.contact_number}
//             onChange={handleChange}
//             required
//           />

//           <button type="submit">Register</button>
//         </form>

//         {message && <p className="message">{message}</p>}

//         <p className="login-text">
//           Already registered?{" "}
//           <Link to="/user-login" className="login-link">
//             Login here
//           </Link>
//         </p>
//       </div>
//     </div>
//   );
// };

// export default RegisterUser;




import React, { useState } from "react";
import { Link } from "react-router-dom";
import api from "../api/axios";
import "./RegisterUser.css";

const RegisterUser = () => {
  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
    address: "",
    contact_number: "",
  });

  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    let { name, value } = e.target;

    // ✅ Allow only 10 digits for contact number
    if (name === "contact_number") {
      if (!/^\d*$/.test(value)) return;    // only numbers
      if (value.length > 10) return;       // max 10 digits
    }

    setForm({ ...form, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // ❌ Prevent submit if contact number is not exactly 10 digits
    if (form.contact_number.length !== 10) {
      setMessage("❌ Contact number must be exactly 10 digits!");
      return;
    }

    try {
      const response = await api.post("/users/", form);
      // setMessage(`✅ User created sucessfully: ${response.data.username}`);
        setMessage(`✅ User created sucessfully`);


      setForm({
        username: "",
        email: "",
        password: "",
        address: "",
        contact_number: "",
      });
    } catch (error) {
      console.error("Error creating user:", error);
      setMessage("❌ User already exists. Please try with another email.");
    }
  };

  return (
    <div className="register-container">
      <div className="register-card">
        <h2>👤 Create New User</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Enter Username"
            value={form.username}
            onChange={handleChange}
            required
          />

          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            value={form.email}
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={form.password}
            onChange={handleChange}
            required
          />

          <input
            type="text"
            name="address"
            placeholder="Enter Address"
            value={form.address}
            onChange={handleChange}
            required
          />

          <input
            type="text"
            name="contact_number"
            placeholder="Enter Contact Number"
            value={form.contact_number}
            onChange={handleChange}
            required
          />

          <button type="submit">Register</button>
        </form>

        {message && <p className="message">{message}</p>}

        <p className="login-text">
          Already registered?{" "}
          <Link to="/user-login" className="login-link">
            Login here
          </Link>
        </p>
      </div>
    </div>
  );
};

export default RegisterUser;
