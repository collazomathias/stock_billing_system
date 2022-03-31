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
import uy.com.sofka.stockbilling.models.vendedores.VendedoresModel;
import uy.com.sofka.stockbilling.services.VendedoresService;

@RestController
@CrossOrigin(origins = "*")
public class VendedoresController {

    @Autowired
    private VendedoresService vendedoresService;

    @PostMapping("/vendedores")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<VendedoresModel> addNewSeller(@RequestBody VendedoresModel vendedoresModel) {
        return this.vendedoresService.addNewSeller(vendedoresModel);
    }

    @GetMapping("/vendedores")
    @ResponseStatus(HttpStatus.OK)
    private Flux<VendedoresModel> getAllSellers() {
        return this.vendedoresService.getAllSellers();
    }

    @GetMapping("/vendedores/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<VendedoresModel> getSellerById(@PathVariable("id") String id) {
        return this.vendedoresService.getSellerById(id);
    }

    @DeleteMapping("/vendedores/{id}")
    private Mono<ResponseEntity<VendedoresModel>> deleteSellerById(@PathVariable("id") String id) {
        return this.vendedoresService.deleteSellerById(id)
            .flatMap(vendedor -> Mono.just(ResponseEntity.ok(vendedor)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/vendedores/{id}")
    private Mono<ResponseEntity<VendedoresModel>> updateSellerById(@PathVariable("id") String id, @RequestBody VendedoresModel vendedoresModel) {
        return this.vendedoresService.updateSellerById(id, vendedoresModel)
            .flatMap(vendedor -> Mono.just(ResponseEntity.ok(vendedor)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}   
