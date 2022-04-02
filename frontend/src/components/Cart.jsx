import React from "react";
import { useDispatch, useSelector } from "react-redux";
import DataTable from "react-data-table-component";
import "../assets/styles/components/Cart.scss";
import { action } from "../actions/action";

export const Cart = () => {

    const { userLogged } = useSelector(state => state.userReducer);

    const { actionAddBill } = action();

    const { productsCart, cartTotalPrice } = useSelector(state => state.productReducer);

    const columns = [
        {
            name: "Product",
            selector: row => row.nombreProducto,
            sortable: true,
            grow: 4
        },
        {
            name: "Price",
            selector: row => row.precioProducto,
            sortable: true
        },
        {
            name: "Quantity",
            selector: row => row.cantProducts,
            sortable: true
        }
    ]

    const dispatch = useDispatch();

    const addBill = async() => {
        dispatch(actionAddBill("02/04/2022", "Juan", userLogged, productsCart, cartTotalPrice));
    }

    return (
        <div className="cart-container">
            <DataTable
                title="CART"
                columns={columns}
                data={productsCart}
                pagination
                fixedHeader
            />
            <div className="bill-container">
                <h4 className="total-amount">Total amount: <span>${cartTotalPrice}</span></h4>
                <button onClick={() => addBill()} className="generate-bill-button">GENERATE BILL</button>
            </div>
        </div>
    );
}