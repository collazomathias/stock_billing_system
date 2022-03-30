package uy.com.sofka.stockbilling.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.stockbilling.models.ProveedoresModel;

public interface ProveedoresRepository extends ReactiveMongoRepository<ProveedoresModel, String> {
    
}