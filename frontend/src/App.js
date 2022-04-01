import React from "react";
import { Routes, Route  } from "react-router-dom";

import Dashboard from "./containers/Dashboard.jsx";
import Login from "./containers/Login";
import Register from "./containers/Register";

function App() {

    return (
        <div className="all-container">
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/register" element={<Register />} />
            </Routes>
        </div>
    );
}

export default App;
