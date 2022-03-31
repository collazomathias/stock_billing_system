package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.volantes.VolantesModel;

public interface VolantesRepository extends ReactiveMongoRepository<VolantesModel, String> {
    
    Mono<VolantesModel> findByIdVolante(String idVolante);

}
