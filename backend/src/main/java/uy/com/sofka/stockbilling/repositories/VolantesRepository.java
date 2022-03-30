package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.stockbilling.models.VolantesModel;

public interface VolantesRepository extends ReactiveMongoRepository<VolantesModel, String> {
    
}
