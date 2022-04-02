package uy.com.sofka.stockbilling.models.productos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductosDTO {
    
    private String idProducto;
    private String nombreProducto;
    private Double precioProducto;
    private String descripcionProducto;
    private Long stockProducto;
    private String categoriaProducto;
    private Long stockMinimo;
    private Long stockMaximo;

    public ProductosDTO(){}

    public ProductosDTO(String nombreProducto, Double precioProducto, String descripcionProducto, Long stockProducto, String categoriaProducto, Long stockMinimo, Long stockMaximo) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.categoriaProducto = categoriaProducto;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
    }

    public ProductosDTO ProductosToDTO(ProductosModel productosModel) {
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setCategoriaProducto(productosModel.getCategoriaProducto());
        productosDTO.setDescripcionProducto(productosModel.getDescripcionProducto());
        productosDTO.setIdProducto(productosModel.getIdProducto());
        productosDTO.setNombreProducto(productosModel.getNombreProducto());
        productosDTO.setPrecioProducto(productosModel.getPrecioProducto());
        productosDTO.setStockMaximo(productosModel.getStockMaximo());
        productosDTO.setStockMinimo(productosModel.getStockMinimo());
        productosDTO.setStockProducto(productosModel.getStockProducto());
        return productosDTO;
    }

    public Mono<ProductosDTO> ProductosModelToDTO(Mono<ProductosModel> productosModel) {
        return productosModel.map(producto -> {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.setCategoriaProducto(producto.getCategoriaProducto());
            productosDTO.setDescripcionProducto(producto.getDescripcionProducto());
            productosDTO.setIdProducto(producto.getIdProducto());
            productosDTO.setNombreProducto(producto.getNombreProducto());
            productosDTO.setPrecioProducto(producto.getPrecioProducto());
            productosDTO.setStockMaximo(producto.getStockMaximo());
            productosDTO.setStockMinimo(producto.getStockMinimo());
            productosDTO.setStockProducto(producto.getStockProducto());
            return productosDTO;
        });
    }

    public Flux<ProductosDTO> ProductosModelListToDTO(Flux<ProductosModel> productosModel) {
        return productosModel.map(producto -> {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.setCategoriaProducto(producto.getCategoriaProducto());
            productosDTO.setDescripcionProducto(producto.getDescripcionProducto());
            productosDTO.setIdProducto(producto.getIdProducto());
            productosDTO.setNombreProducto(producto.getNombreProducto());
            productosDTO.setPrecioProducto(producto.getPrecioProducto());
            productosDTO.setStockMaximo(producto.getStockMaximo());
            productosDTO.setStockMinimo(producto.getStockMinimo());
            return productosDTO;
        });
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
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

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
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
