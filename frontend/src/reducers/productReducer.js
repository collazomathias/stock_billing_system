const initialState = {
    products: [],
}

export const productReducer = (state = initialState, action) => {
    switch(action.type){
        case "addProduct":
            const products = ([...state.products, action.payload]);
            console.log(products)
            return { ...state, products: products }
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