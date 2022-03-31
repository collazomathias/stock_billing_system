package uy.com.sofka.stockbilling.models.facturas;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.productos.ProductosModel;

public class FacturasDTO {
    
    private String idFactura;
    private String fechaFactura;
    private String nombreCliente;
    private String vendedorFactura;
    private List<ProductosModel> listaProductos;
    private Double precioTotal;

    public FacturasDTO(){}

    public FacturasDTO(String fechaFactura, String nombreCliente, String vendedorFactura, List<ProductosModel> listaProductos, Double precioTotal) {
        this.fechaFactura = fechaFactura;
        this.nombreCliente = nombreCliente;
        this.vendedorFactura = vendedorFactura;
        this.listaProductos = listaProductos;
        this.precioTotal = precioTotal;
    }

    public FacturasDTO FacturasToDTO(FacturasModel facturasModel) {
        FacturasDTO facturasDTO = new FacturasDTO();
        facturasDTO.setIdFactura(facturasModel.getIdFactura());
        facturasDTO.setFechaFactura(facturasModel.getFechaFactura());
        facturasDTO.setListaProductos(facturasModel.getListaProductos());
        facturasDTO.setNombreCliente(facturasModel.getNombreCliente());
        facturasDTO.setVendedorFactura(facturasModel.getVendedorFactura());
        facturasDTO.setPrecioTotal(facturasModel.getPrecioTotal());
        return facturasDTO;
    }

    public Mono<FacturasDTO> FacturasModelToDTO(Mono<FacturasModel> facturasModel) {
        return facturasModel.map(factura -> {
            FacturasDTO facturasDTO = new FacturasDTO();
            facturasDTO.setIdFactura(factura.getIdFactura());
            facturasDTO.setFechaFactura(factura.getFechaFactura());
            facturasDTO.setListaProductos(factura.getListaProductos());
            facturasDTO.setNombreCliente(factura.getNombreCliente());
            facturasDTO.setVendedorFactura(factura.getVendedorFactura());
            facturasDTO.setPrecioTotal(factura.getPrecioTotal());
            return facturasDTO;
        });
    }

    public Flux<FacturasDTO> FacturasModelListToDTO(Flux<FacturasModel> facturasModel) {
        return facturasModel.map(factura -> {
            FacturasDTO facturasDTO = new FacturasDTO();
            facturasDTO.setIdFactura(factura.getIdFactura());
            facturasDTO.setFechaFactura(factura.getFechaFactura());
            facturasDTO.setListaProductos(factura.getListaProductos());
            facturasDTO.setNombreCliente(factura.getNombreCliente());
            facturasDTO.setVendedorFactura(factura.getVendedorFactura());
            facturasDTO.setPrecioTotal(factura.getPrecioTotal());
            return facturasDTO;
        });
    }

    public String getIdFactura() {
        return idFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
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

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
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
