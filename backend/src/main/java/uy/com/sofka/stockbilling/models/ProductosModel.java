package uy.com.sofka.stockbilling.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
public class ProductosModel {
    
    @Id
    private Long idProducto;
    private String nombreProducto;
    private Double precioProducto;
    private String descripcionProducto;
    private Long stockProducto;
    private String categoriaProducto;

    public ProductosModel(){}

    public ProductosModel(String nombreProducto, Double precioProducto, String descripcionProducto, Long stockProducto, String categoriaProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.categoriaProducto = categoriaProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    
    public Double getPrecioProducto() {
        return precioProducto;
    }

    public Long getStockProducto() {
        return stockProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

}
