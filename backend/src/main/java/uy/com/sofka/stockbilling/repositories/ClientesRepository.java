package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ClientesModel;

public interface ClientesRepository extends ReactiveMongoRepository<ClientesModel, String> {
    
    Mono<ClientesModel> findByIdCliente(String id);

}
