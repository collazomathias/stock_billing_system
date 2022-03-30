package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.VendedoresModel;

public interface VendedoresRepository extends ReactiveMongoRepository<VendedoresModel, String> {
    
    Mono<VendedoresModel> findByIdVendedor(String idVendedor);

}
