// // src/api/axios.js
// import axios from "axios";

// const api = axios.create({
//   baseURL: "http://127.0.0.1:8000", // FastAPI backend URL
// });

// export default api;

// src/api/axios.js
import axios from "axios";

const api = axios.create({
  baseURL: "http://192.168.0.113:8000",  // Use your LAN IP
});

export default api;
