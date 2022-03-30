package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ClientesModel> addNewClient(@RequestBody ClientesModel clientesModel) {
        return this.clientesService.addNewClient(clientesModel);
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ClientesModel> getAllClients() {
        return this.clientesService.getAllClients();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ClientesModel> getClientById(@PathVariable("id") Long id) {
        return this.clientesService.getClientById(id);
    }

}
