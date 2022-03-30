package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ProductosModel;
import uy.com.sofka.stockbilling.repositories.ProductosRepository;
import uy.com.sofka.stockbilling.services.ProductosService;

@Service
public class ProductosServiceImplementation implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public Mono<ProductosModel> addNewProduct(ProductosModel productosModel) {
        return this.productosRepository.save(productosModel);
    }

    @Override
    public Flux<ProductosModel> getAllProducts() {
        return this.productosRepository.findAll();
    }

    @Override
    public Mono<ProductosModel> getProductById(String id) {
        return this.productosRepository.findByIdProducto(id);
    }

    @Override
    public Mono<ProductosModel> deleteProductById(String id) {
        return this.productosRepository.findByIdProducto(id)
            .flatMap(producto -> productosRepository.deleteById(producto.getIdProducto())
            .thenReturn(producto));
    }

    @Override
    public Mono<ProductosModel> updateProductById(String id, ProductosModel productosModel) {
        return this.productosRepository.findByIdProducto(id)
            .flatMap(producto -> {
                productosModel.setIdProducto(id);
                return addNewProduct(productosModel);
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
