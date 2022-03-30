package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ClientesModel;
import uy.com.sofka.stockbilling.services.ClientesService;

@RestController
public class ClientesController {
    
    @Autowired
    private ClientesService clientesService;

    @PostMapping("/clientes")
    private Mono<ClientesModel> addNewClient(@RequestBody ClientesModel clientesModel) {
        return this.clientesService.addNewClient(clientesModel);
    }

    @GetMapping("/clientes")
    private Flux<ClientesModel> getAllClients() {
        return this.clientesService.getAllClients();
    }

    @GetMapping("/clientes/{id}")
    private Mono<ClientesModel> getClientById(@PathVariable("id") String id) {
        return this.clientesService.getClientById(id);
    }

    @PutMapping("/clientes/delete/{id}")
    private Mono<ResponseEntity<ClientesModel>> deleteClientById(@PathVariable("id") String id) {
        return this.clientesService.deleteClientById(id)
            .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/clientes/update/{id}")
    private Mono<ResponseEntity<ClientesModel>> updateClientById(@PathVariable("id") String id, @RequestBody ClientesModel clientesModel) {
        return this.clientesService.updateClientById(id, clientesModel)
            .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
