const initialState = {
    products: [],
    productsCart: [],
    cartTotalPrice: 0
}

export const productReducer = (state = initialState, action) => {
    switch(action.type){
        case "addProduct":
            const products = ([...state.products, action.payload]);
            return { ...state, products: products }
        case "removeProduct":
            return { state }
        case "updateProduct":
            return { state }
        case "getProducts":
            return { ...state, products: action.payload }
        case "addProductToCart":
            const productsCart = ([...state.productsCart, action.payload]);
            return {...state, productsCart: productsCart, cartTotalPrice: state.cartTotalPrice + (action.payload.precioProducto * action.payload.cantProducts) }
        default: 
            return state;
    }
}