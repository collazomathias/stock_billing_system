package uy.com.sofka.stockbilling.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "facturas")
public class FacturasModel {

    @Id
    private Long idFactura;
    private String fechaFactura;
    private String nombreCliente;
    private String vendedorFactura;
    private List<ProductosModel> listaProductos;
    private Double precioTotal;

    public FacturasModel(){}

    public FacturasModel(String fechaFactura, String nombreCliente, String vendedorFactura, List<ProductosModel> listaProductos, Double precioTotal) {
        this.fechaFactura = fechaFactura;
        this.nombreCliente = nombreCliente;
        this.vendedorFactura = vendedorFactura;
        this.listaProductos = listaProductos;
        this.precioTotal = precioTotal;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public List<ProductosModel> getListaProductos() {
        return listaProductos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public String getVendedorFactura() {
        return vendedorFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public void setListaProductos(List<ProductosModel> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setVendedorFactura(String vendedorFactura) {
        this.vendedorFactura = vendedorFactura;
    }
    
}
