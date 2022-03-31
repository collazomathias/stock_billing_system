package uy.com.sofka.stockbilling.models.productos;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
public class ProductosModel {
    
    @Id
    private String idProducto = UUID.randomUUID().toString().substring(0, 10);
    private String nombreProducto;
    private Double precioProducto;
    private String descripcionProducto;
    private Long stockProducto;
    private String categoriaProducto;
    private Long stockMinimo;
    private Long stockMaximo;

    public ProductosModel(){}

    public ProductosModel(String nombreProducto, Double precioProducto, String descripcionProducto, Long stockProducto, String categoriaProducto, Long stockMinimo, Long stockMaximo) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.categoriaProducto = categoriaProducto;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
    }

    public ProductosModel ProductosDTOToModel(ProductosDTO productosDTO) {
        ProductosModel productosModel = new ProductosModel(
            productosDTO.getNombreProducto(),
            productosDTO.getPrecioProducto(),
            productosDTO.getDescripcionProducto(),
            productosDTO.getStockProducto(),
            productosDTO.getCategoriaProducto(),
            productosDTO.getStockMinimo(),
            productosDTO.getStockMaximo()
        );
        return productosModel;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public String getIdProducto() {
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

    public Long getStockMaximo() {
        return stockMaximo;
    }

    public Long getStockMinimo() {
        return stockMinimo;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setStockMaximo(Long stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public void setStockMinimo(Long stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setStockProducto(Long stockProducto) {
        this.stockProducto = stockProducto;
    }

}
