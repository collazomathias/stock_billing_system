import { signInWithEmailAndPassword, signOut, createUserWithEmailAndPassword } from "firebase/auth";


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

export const action = () => {
    return { actionLog, actionDeslog, actionRegister }
}