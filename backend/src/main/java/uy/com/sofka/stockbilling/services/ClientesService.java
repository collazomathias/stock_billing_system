package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ClientesModel;

public interface ClientesService {

    Mono<ClientesModel> addNewClient(ClientesModel clientesModel);
    Flux<ClientesModel> getAllClients();
    Mono<ClientesModel> getClientById(String id);
    Mono<ClientesModel> deleteClientById(String id);
    Mono<ClientesModel> updateClientById(String id, ClientesModel clientesModel);
    
}
