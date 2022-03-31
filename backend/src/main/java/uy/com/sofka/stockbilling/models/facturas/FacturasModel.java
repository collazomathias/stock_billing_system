package uy.com.sofka.stockbilling.models.facturas;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import uy.com.sofka.stockbilling.models.productos.ProductosModel;

@Document(collection = "facturas")
public class FacturasModel {

    @Id
    private String idFactura = UUID.randomUUID().toString().substring(0, 10);
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

    public FacturasModel FacturasDTOToModel(FacturasDTO facturasDTO) {
        FacturasModel facturasModel = new FacturasModel(
            facturasDTO.getFechaFactura(),
            facturasDTO.getNombreCliente(),
            facturasDTO.getVendedorFactura(),
            facturasDTO.getListaProductos(),
            facturasDTO.getPrecioTotal()
        );
        return facturasModel;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public String getIdFactura() {
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

    public void setIdFactura(String idFactura) {
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
