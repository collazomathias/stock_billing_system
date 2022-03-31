package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.volantes.VolantesDTO;
import uy.com.sofka.stockbilling.models.volantes.VolantesModel;
import uy.com.sofka.stockbilling.repositories.VolantesRepository;
import uy.com.sofka.stockbilling.services.VolantesService;

@Service
public class VolantesServiceImplementation implements VolantesService {

    @Autowired
    private VolantesRepository volantesRepository;

    private VolantesDTO volantesDTO = new VolantesDTO();
    private VolantesModel volantesModel = new VolantesModel();

    @Override
    public Mono<VolantesDTO> addNewVolante(VolantesDTO volantes) {
        Mono<VolantesModel> newVolante = volantesRepository.save(volantesModel.VendedoresDTOToModel(volantes));
        return volantesDTO.VendedoresModelToDTO(newVolante);
    }

    @Override
    public Flux<VolantesDTO> getAllVolantes() {
        Flux<VolantesModel> volantes = volantesRepository.findAll();
        return volantesDTO.VendedoresModelListToDTO(volantes);
    }

    @Override
    public Mono<VolantesDTO> getVolanteById(String id) {
        Mono<VolantesModel> volante = volantesRepository.findByIdVolante(id);
        return volantesDTO.VendedoresModelToDTO(volante);
    }

    @Override
    public Mono<VolantesDTO> deleteVolanteById(String id) {
        return this.volantesRepository.findByIdVolante(id)
            .flatMap(volante -> volantesRepository.deleteById(volante.getIdVolante())
            .thenReturn(volantesDTO.VendedoresToDTO(volante)));
    }

    @Override
    public Mono<VolantesDTO> updateVolanteById(String id, VolantesDTO volantes) {
        return this.volantesRepository.findByIdVolante(id) 
            .flatMap(volante -> {
                volante.setIdVolante(id);
                volante.setFechaVolante(volantesModel.getFechaVolante());
                volante.setIdProveedor(volantesModel.getIdProveedor());
                volante.setListaProductos(volantesModel.getListaProductos());
                return volantesDTO.VendedoresModelToDTO(volantesRepository.save(volante));
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
