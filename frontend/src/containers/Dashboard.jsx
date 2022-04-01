import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { action } from "../actions/action";
import firebaseApp from "../firebase/credentials";
import { getAuth } from "firebase/auth";
import { useNavigate } from "react-router";

const Dashboard = () => {

    const { alertMessage, userLogged } = useSelector(state => state.userReducer);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const { actionDeslog } = action();

    const auth = getAuth(firebaseApp);

    const userDeslog = async(event) => {
        event.preventDefault();
        dispatch(actionDeslog(auth));
    }

    useEffect(() => {
        if(!userLogged) navigate("/login");
    }, [userLogged])
    

    return (
        <>
            <div>Dashboard</div>
            <button onClick={userDeslog}>SIGN OUT</button>
        </>
    );
}
 
export default Dashboard;