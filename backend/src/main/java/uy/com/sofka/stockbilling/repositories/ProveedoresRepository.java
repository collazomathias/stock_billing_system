package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.proveedores.ProveedoresModel;

public interface ProveedoresRepository extends ReactiveMongoRepository<ProveedoresModel, String> {
    
    Mono<ProveedoresModel> findByIdProveedor(String idProveedor);

}
