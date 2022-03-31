package uy.com.sofka.stockbilling.models.volantes;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import uy.com.sofka.stockbilling.models.productos.ProductosModel;

@Document(collection = "volantes")
public class VolantesModel {
    
    @Id
    private String idVolante = UUID.randomUUID().toString().substring(0, 10);
    private String idProveedor;
    private String fechaVolante;
    private List<ProductosModel> listaProductos;

    public VolantesModel(){}

    public VolantesModel(String idProveedor, String fechaVolante, List<ProductosModel> listaProductos) {
        this.idProveedor = idProveedor;
        this.fechaVolante = fechaVolante;
        this.listaProductos = listaProductos;
    }

    public VolantesModel VendedoresDTOToModel(VolantesDTO volantesDTO) {
        VolantesModel volantesModel = new VolantesModel(
            volantesDTO.getIdProveedor(),
            volantesDTO.getFechaVolante(),
            volantesDTO.getListaProductos()
        );
        return volantesModel;
    }

    public String getFechaVolante() {
        return fechaVolante;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public String getIdVolante() {
        return idVolante;
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

    public void setIdVolante(String idVolante) {
        this.idVolante = idVolante;
    }

    public void setListaProductos(List<ProductosModel> listaProductos) {
        this.listaProductos = listaProductos;
    }

}