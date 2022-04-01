const initialState = {
    userLogged: null,
    alertMessage: ""
}

export const userReducer = (state = initialState, action) => {
    switch(action.type){
        case "stateUser":
            return { ...state, userLogged: action.payload, alertMessage: "" }
        case "alertMessage":
            return { ...state, alertMessage: action.payload }
        default: 
            return state;
    }
}