import React from "react";
import { useSelector } from "react-redux";

export const Cart = () => {

    const { productsCart, cartTotalPrice } = useSelector(state => state.productReducer);

    return (
        <div>
            <h3>CART</h3>
            <table>
                <thead>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </thead>
                <tbody>
                    {
                        productsCart.map((product) => {
                            <td>{product.nombreProducto}</td>
                        })
                    }
                </tbody>
            </table>
        </div>
    );
}