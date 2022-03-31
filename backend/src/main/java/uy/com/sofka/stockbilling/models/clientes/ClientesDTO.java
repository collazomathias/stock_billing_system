package uy.com.sofka.stockbilling.models.clientes;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ClientesDTO {
    
    private String idCliente;
    private String nombreCliente;
    private String telefonoCliente;

    public ClientesDTO(){}

    public ClientesDTO(String nombreCliente, String telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
    }

    public ClientesDTO clientesToDTO(ClientesModel cliente) {
        ClientesDTO clientesDTO = new ClientesDTO();
        clientesDTO.setIdCliente(cliente.getIdCliente());
        clientesDTO.setNombreCliente(cliente.getNombreCliente());
        clientesDTO.setTelefonoCliente(cliente.getTelefonoCliente());
        return clientesDTO;
    }

    public Mono<ClientesDTO> ClientesModelToDTO(Mono<ClientesModel> clientesModel) {
        return clientesModel.map(cliente -> {
            ClientesDTO clientesDTO = new ClientesDTO();
            clientesDTO.setIdCliente(cliente.getIdCliente());
            clientesDTO.setNombreCliente(cliente.getNombreCliente());
            clientesDTO.setTelefonoCliente(cliente.getTelefonoCliente());
            return clientesDTO;
        });
    }

    public Flux<ClientesDTO> ClientesModelListToDTO(Flux<ClientesModel> clientesModel) {
        return clientesModel.map(cliente -> {
            ClientesDTO clientesDTO = new ClientesDTO();
            clientesDTO.setIdCliente(cliente.getIdCliente());
            clientesDTO.setNombreCliente(cliente.getNombreCliente());
            clientesDTO.setTelefonoCliente(cliente.getTelefonoCliente());
            return clientesDTO;
        });
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

}
