package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.productos.ProductosDTO;

public interface ProductosService {

    Mono<ProductosDTO> addNewProduct(ProductosDTO productosDTO);
    Flux<ProductosDTO> getAllProducts();
    Mono<ProductosDTO> getProductById(String id);
    Mono<ProductosDTO> deleteProductById(String id);
    Mono<ProductosDTO> updateProductById(String id, ProductosDTO productosDTO);
    
}
