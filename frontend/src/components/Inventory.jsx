import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { action } from "../actions/action";
import DataTable from "react-data-table-component";
import "../assets/styles/components/Inventory.scss";

export const Inventory = () => {

    const { products } = useSelector(state => state.productReducer);

    const { actionGetProducts } = action();

    const [ formStatus, setFormStatus ] = useState(false);
    
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(actionGetProducts())
    }, [actionGetProducts, dispatch]);

    const columns = [
        {
            name: "ID",
            selector: row => row.idProducto,
            sortable: true,
            grow: 3
        },
        {
            name: "Producto",
            selector: row => row.nombreProducto,
            sortable: true,
            grow: 3
        },
        {
            name: "Precio",
            selector: row => row.precioProducto,
            sortable: true
        }
    ]

    return (
        <div className="inventory-container">
            {
                (formStatus) ? <>
                    <button onClick={() => setFormStatus(false)} className="add-product-button">BACK TO LIST</button>
                    <div className="add-product-container">
                        <label className="add-product-label">Name</label>
                        <input className="add-product-input" type="text" />
                        <label className="add-product-label">Description</label>
                        <input className="add-product-input" type="text" />
                        <label className="add-product-label">Category</label>
                        <input className="add-product-input" type="text" />
                        <label className="add-product-label">Price</label>
                        <input className="add-product-input" type="text" />
                        <label className="add-product-label">Stock</label>
                        <input className="add-product-input" type="text" />
                        <label className="add-product-label">Minimum stock (for alerts)</label>
                        <input className="add-product-input" type="text" />
                        <label className="add-product-label">Maximum stock (for alerts)</label>
                        <input className="add-product-input" type="text" />
                        <button onClick={() => { setFormStatus(false); }} className="add-product-button green">ADD PRODUCT</button>
                    </div>
                </>
                :
                <>
                    <button onClick={() => setFormStatus(true)} className="add-product-button">ADD PRODUCT</button>
                    <DataTable 
                        columns={columns} 
                        data={products} 
                        title="Products" 
                        pagination 
                        fixedHeader
                        fixedHeaderScrollHeight="100%" />
                </>
            }
        </div>
    );
}