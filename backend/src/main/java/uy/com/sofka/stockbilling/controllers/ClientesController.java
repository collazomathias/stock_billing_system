package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
import uy.com.sofka.stockbilling.models.clientes.ClientesDTO;
import uy.com.sofka.stockbilling.services.ClientesService;

@RestController
@CrossOrigin(origins = "*")
public class ClientesController {
    
    @Autowired
    private ClientesService clientesService;

    @PostMapping("/clientes")
    private Mono<ClientesDTO> addNewClient(@RequestBody ClientesDTO clientesDTO) {
        return this.clientesService.addNewClient(clientesDTO);
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ClientesDTO> getAllClients() {
        return this.clientesService.getAllClients();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ClientesDTO> getClientById(@PathVariable("id") String id) {
        return this.clientesService.getClientById(id);
    }

    @DeleteMapping("/clientes/{id}")
    private Mono<ResponseEntity<ClientesDTO>> deleteClientById(@PathVariable("id") String id) {
        return this.clientesService.deleteClientById(id)
            .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/clientes/{id}")
    private Mono<ResponseEntity<ClientesDTO>> updateClientById(@PathVariable("id") String id, @RequestBody ClientesDTO clientesDTO) {
        return this.clientesService.updateClientById(id, clientesDTO)
            .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
