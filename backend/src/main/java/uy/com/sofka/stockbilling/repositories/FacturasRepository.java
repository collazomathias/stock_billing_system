package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.FacturasModel;

public interface FacturasRepository extends ReactiveMongoRepository<FacturasModel, String> {
    
    Mono<FacturasModel> findByIdFactura(String idFactura);

}   
