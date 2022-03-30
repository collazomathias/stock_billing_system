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
import uy.com.sofka.stockbilling.models.ProveedoresModel;
import uy.com.sofka.stockbilling.services.ProveedoresService;

@RestController
@CrossOrigin(origins = "*")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    @PostMapping("/proveedores")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProveedoresModel> addNewSupplier(@RequestBody ProveedoresModel proveedoresModel) {
        return this.proveedoresService.addNewSupplier(proveedoresModel);
    }

    @GetMapping("/proveedores")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ProveedoresModel> getAllSuppliers() {
        return this.proveedoresService.getAllSuppliers();
    }

    @GetMapping("/proveedores/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ProveedoresModel> getSupplierById(@PathVariable("id") String id) {
        return this.proveedoresService.getSupplierById(id);
    }

    @DeleteMapping("/proveedores/{id}")
    private Mono<ResponseEntity<ProveedoresModel>> deleteSupplierById(@PathVariable("id") String id) {
        return this.proveedoresService.deleteSupplierById(id)
            .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/proveedores/{id}")
    private Mono<ResponseEntity<ProveedoresModel>> updateSupplierById(@PathVariable("id") String id, @RequestBody ProveedoresModel proveedoresModel) {
        return this.proveedoresService.updateSupplierById(id, proveedoresModel)
            .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
}
