package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ClientesModel;
import uy.com.sofka.stockbilling.repositories.ClientesRepository;
import uy.com.sofka.stockbilling.services.ClientesService;

@Service
public class ClientesServiceImplementation implements ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public Mono<ClientesModel> addNewClient(ClientesModel clientesModel) {
        return this.clientesRepository.save(clientesModel);
    }

    @Override
    public Flux<ClientesModel> getAllClients() {
        return this.clientesRepository.findAll();
    }

    @Override
    public Mono<ClientesModel> getClientById(String id) {
        return this.clientesRepository.findByIdCliente(id);
    }

    @Override
    public Mono<ClientesModel> deleteClientById(String id) {
        return this.clientesRepository.findByIdCliente(id)
            .flatMap(cliente -> this.clientesRepository.deleteById(cliente.getIdCliente())
            .thenReturn(cliente));
    }

    @Override
    public Mono<ClientesModel> updateClientById(String id, ClientesModel clientesModel) {
        return this.clientesRepository.findByIdCliente(id)
            .flatMap(cliente -> {
                clientesModel.setIdCliente(id);
                return addNewClient(clientesModel);
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
