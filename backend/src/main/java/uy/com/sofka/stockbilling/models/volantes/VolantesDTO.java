package uy.com.sofka.stockbilling.models.volantes;

import java.util.List;

import uy.com.sofka.stockbilling.models.productos.ProductosModel;

public class VolantesDTO {
    
    private String idProveedor;
    private String fechaVolante;
    private List<ProductosModel> listaProductos;

    public VolantesDTO(){}

    public VolantesDTO(String idProveedor, String fechaVolante, List<ProductosModel> listaProductos) {
        this.idProveedor = idProveedor;
        this.fechaVolante = fechaVolante;
        this.listaProductos = listaProductos;
    }

    public String getFechaVolante() {
        return fechaVolante;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public List<ProductosModel> getListaProductos() {
        return listaProductos;
    }

    public void setFechaVolante(String fechaVolante) {
        this.fechaVolante = fechaVolante;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setListaProductos(List<ProductosModel> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
