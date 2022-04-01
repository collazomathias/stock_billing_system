import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router";
import { Inventory } from "../components/Inventory";
import { Navbar } from "../components/Navbar";
import "../assets/styles/containers/Dashboard.scss";

const Dashboard = () => {

    const { userLogged } = useSelector(state => state.userReducer);

    const navigate = useNavigate();

    useEffect(() => {
        if(!userLogged) navigate("/");
    }, [navigate, userLogged])
    

    return (
        <>
            <Navbar />
            <div className="dashboard-container">
                <Inventory />
            </div>
        </>
    );
}
 
export default Dashboard;