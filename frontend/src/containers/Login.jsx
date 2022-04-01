import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAuth } from "firebase/auth";
import { action } from "../actions/action";
import firebaseApp from "../firebase/credentials";
import "../assets/styles/containers/Login.scss";
import { useNavigate } from "react-router";

const Login = () => {

    const { alertMessage, userLogged } = useSelector(state => state.userReducer);

    const [ email, setEmail ] = useState("");
    const [ password, setPassword ] = useState("");
    const [ errorMessage, setErrorMessage ] = useState("");
    const auth = getAuth(firebaseApp);

    const navigate = useNavigate();

    const dispatch = useDispatch();
    const { actionLog, actionRegister } = action();

    useEffect(() => {
        if(userLogged) navigate("/dashboard");
    }, [userLogged])

    useEffect(() => {
        if(alertMessage) setErrorMessage(alertMessage);
    }, [alertMessage])

    const userLog = async(event) => {
        event.preventDefault();
        dispatch(actionLog(auth, email, password));
    }

    const userRegister = async(event) => {
        event.preventDefault();
        dispatch(actionRegister(auth, email, password))
    }

    return (
        <>
            <div className="all-login-container">
                {(errorMessage) ? 
                    <div className="error-message">{ errorMessage }</div>
                    :
                    null
                }
                <form>
                    <div className="login-container">
                        <div className="login-label-input-container">
                            <label className="login-label" htmlFor="user-input">Email</label>
                            <input className="login-input" type="email" placeholder="Text your email here.." 
                                onChange={(event) => setEmail(event.target.value)}
                            />
                        </div>
                        <div className="login-label-input-container">
                            <label className="login-label" htmlFor="user-input">Password</label>
                            <input className="login-input" type="password" placeholder="Text your password here.." 
                                onChange={(event) => setPassword(event.target.value)}
                            />
                        </div>
                        <div className="buttons-login-container">
                            <button className="login-button btn-primary" onClick={(event) => userLog(event)}>LOG IN</button>
                            <button className="login-button" onClick={(event) => userRegister(event)}>SIGN IN</button>
                        </div>
                    </div>
                </form>
                <button className="login-google-button">LOG IN WITH GOOGLE!</button>
            </div>
        </>
    );
}
 
export default Login;
