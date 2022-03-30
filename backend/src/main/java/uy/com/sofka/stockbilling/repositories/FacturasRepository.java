package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.stockbilling.models.FacturasModel;

public interface FacturasRepository extends ReactiveMongoRepository<FacturasModel, String> {
    
}
