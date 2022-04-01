import React from 'react'
import { useSelector, useDispatch } from 'react-redux';
import firebaseApp from "../firebase/credentials";
import { action } from "../actions/action";
import { getAuth } from "firebase/auth";
import "../assets/styles/components/Navbar.scss";

export const Navbar = () => {

    const auth = getAuth(firebaseApp);
    
    const dispatch = useDispatch();

    const { userLogged } = useSelector(state => state.userReducer);

    const { actionDeslog } = action();

    const userDeslog = async(event) => {
        event.preventDefault();
        dispatch(actionDeslog(auth));
    }

    return (
        <div className='navbar-container'>
            <h3>Welcome, <span>{userLogged}</span></h3>
            <button onClick={userDeslog}>SIGN OUT</button>
        </div>
    );
}