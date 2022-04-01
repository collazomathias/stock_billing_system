const initialState = {
    products: [],
}

export const productReducer = (state = initialState, action) => {
    switch(action.type){
        case "addProduct":
            return { ...state, products: action.payload }
        case "removeProduct":
            return { state }
        case "updateProduct":
            return { state }
        case "getProducts":
            return { ...state, products: action.payload }
        default: 
            return state;
    }
}