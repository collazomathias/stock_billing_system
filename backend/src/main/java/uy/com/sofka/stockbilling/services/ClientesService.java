package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.clientes.ClientesDTO;

public interface ClientesService {

    Mono<ClientesDTO> addNewClient(ClientesDTO clientesDTO);
    Flux<ClientesDTO> getAllClients();
    Mono<ClientesDTO> getClientById(String id);
    Mono<ClientesDTO> deleteClientById(String id);
    Mono<ClientesDTO> updateClientById(String id, ClientesDTO clientesDTO);
    
}
