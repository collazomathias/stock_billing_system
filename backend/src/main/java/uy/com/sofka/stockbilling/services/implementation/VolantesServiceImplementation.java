package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.VolantesModel;
import uy.com.sofka.stockbilling.repositories.VolantesRepository;
import uy.com.sofka.stockbilling.services.VolantesService;

@Service
public class VolantesServiceImplementation implements VolantesService {

    @Autowired
    private VolantesRepository volantesRepository;

    @Override
    public Mono<VolantesModel> addNewVolante(VolantesModel volantesModel) {
        return this.volantesRepository.save(volantesModel);
    }

    @Override
    public Flux<VolantesModel> getAllVolantes() {
        return this.volantesRepository.findAll();
    }

    @Override
    public Mono<VolantesModel> getVolanteById(String id) {
        return this.volantesRepository.findByIdVolante(id);
    }

    @Override
    public Mono<VolantesModel> deleteVolanteById(String id) {
        return this.volantesRepository.findByIdVolante(id)
            .flatMap(volante -> volantesRepository.deleteById(volante.getIdVolantes())
            .thenReturn(volante));
    }

    @Override
    public Mono<VolantesModel> updateVolanteById(String id, VolantesModel volantesModel) {
        return this.volantesRepository.findByIdVolante(id) 
            .flatMap(volante -> {
                volantesModel.setIdVolantes(id);
                return addNewVolante(volantesModel);
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
