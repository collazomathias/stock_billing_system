package uy.com.sofka.stockbilling.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class ClientesModel {

    @Id
    private String idCliente = UUID.randomUUID().toString().substring(0, 10);
    private String nombreCliente;
    private String telefonoCliente;

    public ClientesModel(){}

    public ClientesModel(String nombreCliente, String telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
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
