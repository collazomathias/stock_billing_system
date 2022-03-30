package uy.com.sofka.stockbilling.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendedores")
public class VendedoresModel {

    @Id
    private String idVendedor = UUID.randomUUID().toString().substring(0, 10);
    private String nombreVendedor;
    
    public VendedoresModel(){}

    public VendedoresModel(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    
}
