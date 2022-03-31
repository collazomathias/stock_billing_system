package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.volantes.VolantesDTO;

public interface VolantesService {

    Mono<VolantesDTO> addNewVolante(VolantesDTO volantesDTO);
    Flux<VolantesDTO> getAllVolantes();
    Mono<VolantesDTO> getVolanteById(String id);
    Mono<VolantesDTO> deleteVolanteById(String id);
    Mono<VolantesDTO> updateVolanteById(String id, VolantesDTO volantesDTO);
    
}
