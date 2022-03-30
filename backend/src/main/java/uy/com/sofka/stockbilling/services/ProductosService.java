package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ProductosModel;

public interface ProductosService {

    Mono<ProductosModel> addNewProduct(ProductosModel productosModel);
    Flux<ProductosModel> getAllProducts();
    Mono<ProductosModel> getProductById(String id);
    Mono<ProductosModel> deleteProductById(String id);
    Mono<ProductosModel> updateProductById(String id, ProductosModel productosModel);
    
}
