package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.clientes.ClientesDTO;
import uy.com.sofka.stockbilling.models.clientes.ClientesModel;
import uy.com.sofka.stockbilling.repositories.ClientesRepository;
import uy.com.sofka.stockbilling.services.ClientesService;

@Service
public class ClientesServiceImplementation implements ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    ClientesDTO clientesDTO = new ClientesDTO();
    ClientesModel clientesModel = new ClientesModel();

    @Override
    public Mono<ClientesDTO> addNewClient(ClientesDTO clientesDTO) {
        Mono<ClientesModel> newClient =  clientesRepository.save(clientesModel.ClientesDTOToModel(clientesDTO));
        return clientesDTO.ClientesModelToDTO(newClient);
    }

    @Override
    public Flux<ClientesDTO> getAllClients() {
        Flux<ClientesModel> clients = clientesRepository.findAll();
        return clientesDTO.ClientesModelListToDTO(clients);
    }

    @Override
    public Mono<ClientesDTO> getClientById(String id) {
        Mono<ClientesModel> client = clientesRepository.findById(id);
        return clientesDTO.ClientesModelToDTO(client);
    }

    @Override
    public Mono<ClientesDTO> deleteClientById(String id) {
        return this.clientesRepository.findByIdCliente(id)
            .flatMap(cliente -> this.clientesRepository.deleteById(cliente.getIdCliente())
            .thenReturn(clientesDTO.clientesToDTO(cliente)));
    }

    @Override
    public Mono<ClientesDTO> updateClientById(String id, ClientesDTO clientesDTO) {
        return this.clientesRepository.findByIdCliente(id)
            .flatMap(cliente -> {
                cliente.setIdCliente(id);
                cliente.setNombreCliente(clientesDTO.getNombreCliente());
                cliente.setTelefonoCliente(clientesDTO.getTelefonoCliente());
                return clientesDTO.ClientesModelToDTO(clientesRepository.save(cliente));
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
