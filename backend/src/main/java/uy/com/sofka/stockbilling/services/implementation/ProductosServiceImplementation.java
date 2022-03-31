package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.productos.ProductosDTO;
import uy.com.sofka.stockbilling.models.productos.ProductosModel;
import uy.com.sofka.stockbilling.repositories.ProductosRepository;
import uy.com.sofka.stockbilling.services.ProductosService;

@Service
public class ProductosServiceImplementation implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    private ProductosDTO productosDTO = new ProductosDTO();
    private ProductosModel productosModel = new ProductosModel();

    @Override
    public Mono<ProductosDTO> addNewProduct(ProductosDTO productos) {
        Mono<ProductosModel> newProduct = productosRepository.save(productosModel.ProductosDTOToModel(productos));
        return productosDTO.ProductosModelToDTO(newProduct);
    }

    @Override
    public Flux<ProductosDTO> getAllProducts() {
        Flux<ProductosModel> products = productosRepository.findAll();
        return productosDTO.ProductosModelListToDTO(products);
    }

    @Override
    public Mono<ProductosDTO> getProductById(String id) {
        Mono<ProductosModel> product = productosRepository.findByIdProducto(id);
        return productosDTO.ProductosModelToDTO(product);
    }

    @Override
    public Mono<ProductosDTO> deleteProductById(String id) {
        return this.productosRepository.findByIdProducto(id)
            .flatMap(producto -> productosRepository.deleteById(producto.getIdProducto())
            .thenReturn(productosDTO.ProductosToDTO(producto)));
    }

    @Override
    public Mono<ProductosDTO> updateProductById(String id, ProductosDTO productos) {
        return this.productosRepository.findByIdProducto(id)
            .flatMap(producto -> {
                producto.setIdProducto(id);
                producto.setCategoriaProducto(producto.getCategoriaProducto());
                producto.setDescripcionProducto(producto.getDescripcionProducto());
                producto.setNombreProducto(producto.getNombreProducto());
                producto.setPrecioProducto(producto.getPrecioProducto());
                producto.setStockProducto(producto.getStockProducto());
                producto.setStockMaximo(producto.getStockMaximo());
                producto.setStockMinimo(producto.getStockMinimo());
                return productosDTO.ProductosModelToDTO(productosRepository.save(producto));
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
