package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ProductosModel;

public interface ProductosRepository extends ReactiveMongoRepository<ProductosModel, String> {
    Mono<ProductosModel> findByIdProducto(String id);
}
