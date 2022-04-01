import React from "react";
import { Routes, Route  } from "react-router-dom";
import Dashboard from "./containers/Dashboard.jsx";
import Login from "./containers/Login";

function App() {

    return (
        <div className="all-container">
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/dashboard" element={<Dashboard />} />
            </Routes>
        </div>
    );
}

export default App;
