import { signInWithEmailAndPassword, signOut, createUserWithEmailAndPassword } from "firebase/auth";
import { useEffect } from "react";


const actionLog = (auth, email, password) => async(dispatch) => {
    try {
        const userLogged = await signInWithEmailAndPassword(auth, email, password);
        dispatch({
            type: "stateUser",
            payload: userLogged.user.email
        })
    } catch (error) {
        dispatch({
            type: "alertMessage",
            payload: error.message
        })
    }

}

const actionDeslog = (auth) => async(dispatch) => {
    try {
        signOut(auth);
        dispatch({
            type: "stateUser",
            payload: null
        })
    } catch (error) {
        dispatch({
            type: "alertMessage",
            payload: error.message
        })
    }

}

const actionRegister = (auth, email, password) => async(dispatch) => {
    try {
        createUserWithEmailAndPassword(auth, email, password);
    } catch(error) {
        dispatch({
            type: "alertMessage",
            payload: error.message
        })
    }

}

const actionGetProducts = () => async(dispatch) => {
    try {
        fetch("http://localhost:8080/productos")
            .then(response => response.json())
            .then(data => dispatch({
                type: "getProducts",
                payload: data
            }));
    } catch(error) {
        console.log(error.message);
    }
}

const actionAddProduct = () => async(dispatch) => {
    try {
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ title: "React POST" })
        };
        fetch("http://localhost:8080/productos", requestOptions)
            .then(response => response.json())
            .then(data => dispatch({
                type: "addProduct",
                payload: data
            }));
    } catch(error) {
        console.log(error.message);
    }
}

export const action = () => {
    return { actionLog, actionDeslog, actionRegister, actionGetProducts }
}