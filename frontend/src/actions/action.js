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

const actionAddProduct = (nombreProducto, 
                        precioProducto, 
                        descripcionProducto, 
                        stockProducto, 
                        categoriaProducto, 
                        stockMinimo, 
                        stockMaximo) => async(dispatch) => {
    try {
        const request = {
            nombreProducto: nombreProducto,
            precioProducto: precioProducto,
            descripcionProducto: descripcionProducto,
            stockProducto: stockProducto,
            categoriaProducto: categoriaProducto,
            stockMinimo: stockMinimo,
            stockMaximo: stockMaximo
        }
        fetch("http://localhost:8080/productos", {
            method: "POST",
            body: JSON.stringify(request),
            headers: { "Content-Type": "application/json" }
        })
            .then(response => response.json())
            .then(data => dispatch({
                type: "addProduct",
                payload: data
            }));
    } catch(error) {
        console.log(error.message);
    }
}

const actionAddProductToCart = (idProducto, 
                                nombreProducto, 
                                precioProducto, 
                                categoriaProducto, 
                                stockProducto, 
                                descripcionProducto,
                                stockMinimo,
                                stockMaximo,
                                cantProducts) => async(dispatch) => {
    try {
        const product = {idProducto, nombreProducto, precioProducto, 
            categoriaProducto, stockProducto, descripcionProducto, stockMinimo, stockMaximo, cantProducts};
        dispatch({
            type: "addProductToCart",
            payload: product
        })
    } catch(error) {
        console.log(error.message);
    }
                                    
}

export const action = () => {
    return { actionAddProductToCart, actionLog, actionDeslog, actionRegister, actionGetProducts, actionAddProduct }
}