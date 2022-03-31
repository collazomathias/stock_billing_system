package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.volantes.VolantesModel;
import uy.com.sofka.stockbilling.services.VolantesService;

@RestController
@CrossOrigin(origins = "*")
public class VolantesController {

    @Autowired
    private VolantesService volantesService;

    @PostMapping("/volantes")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<VolantesModel> addNewVolante(@RequestBody VolantesModel volantesModel) {
        return this.volantesService.addNewVolante(volantesModel);
    }

    @GetMapping("/volantes")
    @ResponseStatus(HttpStatus.OK)
    private Flux<VolantesModel> getAllVolantes() {
        return this.volantesService.getAllVolantes();
    }

    @GetMapping("/volantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<VolantesModel> getVolanteById(@PathVariable("id") String id) {
        return this.volantesService.getVolanteById(id);
    }

    @DeleteMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolantesModel>> deleteVolanteById(@PathVariable("id") String id) {
        return this.volantesService.deleteVolanteById(id)
            .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolantesModel>> updateVolanteById(@PathVariable("id") String id, @RequestBody VolantesModel volantesModel) {
        return this.volantesService.updateVolanteById(id, volantesModel)
            .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
}
