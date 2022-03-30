package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.VolantesModel;

public interface VolantesService {

    Mono<VolantesModel> addNewVolante(VolantesModel volantesModel);
    Flux<VolantesModel> getAllVolantes();
    Mono<VolantesModel> getVolanteById(String id);
    Mono<VolantesModel> deleteVolanteById(String id);
    Mono<VolantesModel> updateVolanteById(String id, VolantesModel volantesModel);
    
}
