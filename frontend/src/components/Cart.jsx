import React from "react";
import { useSelector } from "react-redux";
import DataTable from "react-data-table-component";
import "../assets/styles/components/Cart.scss";

export const Cart = () => {

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
                <button className="generate-bill-button">GENERATE BILL</button>
            </div>
        </div>
    );
}