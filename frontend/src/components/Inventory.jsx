import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { action } from "../actions/action";
import "../assets/styles/components/Inventory.scss";
import DataTable from "react-data-table-component";

export const Inventory = () => {

    const [ nombreProducto, setNombreProducto ] = useState("");
    const [ precioProducto, setPrecioProducto ] = useState("");
    const [ categoriaProducto, setCategoriaProducto ] = useState("");
    const [ descripcionProducto, setDescripcionProducto ] = useState("");
    const [ stockProducto, setStockProducto ] = useState("");
    const [ stockMinimo, setStockMinimo ] = useState("");
    const [ stockMaximo, setStockMaximo ] = useState("");

    const { actionGetProducts, actionAddProduct } = action();

    const [ formStatus, setFormStatus ] = useState(false);
    
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(actionGetProducts())
    }, []);

    const { products } = useSelector(state => state.productReducer);

    const addProduct = async() => {
        dispatch(actionAddProduct(nombreProducto, 
                        precioProducto, 
                        categoriaProducto, 
                        stockProducto, 
                        descripcionProducto,
                        stockMinimo,
                        stockMaximo));
    }

    const addProductToBill = async() => {

    }

    const columns = [
        {
            name: "ID",
            selector: row => row.idProducto,
            sortable: true
        },
        {
            name: "Product",
            selector: row => row.nombreProducto,
            sortable: true,
            grow: 3
        },
        {
            name: "Price",
            selector: row => row.precioProducto,
            sortable: true
        },
        {
            name: "Action",
            cell: row => <button className="add-button" id={row.idProducto}>ADD</button>
        }
    ]

    console.log(products);

    return (
        <div className="inventory-container">
            {
                (formStatus) ? <>
                    <button onClick={() => setFormStatus(false)} className="add-product-button">BACK TO LIST</button>
                    <div className="add-product-container">
                        <label className="add-product-label">Name</label>
                        <input onChange={(event) => setNombreProducto(event.target.value)} className="add-product-input" type="text" />
                        <label className="add-product-label">Description</label>
                        <input onChange={(event) => setDescripcionProducto(event.target.value)} className="add-product-input" type="text" />
                        <label className="add-product-label">Category</label>
                        <input onChange={(event) => setCategoriaProducto(event.target.value)} className="add-product-input" type="text" />
                        <label className="add-product-label">Price</label>
                        <input onChange={(event) => setPrecioProducto(event.target.value)} className="add-product-input" type="text" />
                        <label className="add-product-label">Stock</label>
                        <input onChange={(event) => setStockProducto(event.target.value)} className="add-product-input" type="text" />
                        <label className="add-product-label">Minimum stock (for alerts)</label>
                        <input onChange={(event) => setStockMinimo(event.target.value)} className="add-product-input" type="text" />
                        <label className="add-product-label">Maximum stock (for alerts)</label>
                        <input onChange={(event) => setStockMaximo(event.target.value)} className="add-product-input" type="text" />
                        <button onClick={() => { addProduct(); setFormStatus(false); }} className="add-product-button green">ADD PRODUCT</button>
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
                        fixedHeaderScrollHeight="600px"
                    />
                </>
            }
        </div>
    );
}