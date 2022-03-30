package uy.com.sofka.stockbilling.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendedores")
public class VendedoresModel {

    @Id
    private Long idVendedor;
    private String nombreVendedor;
    
    public VendedoresModel(){}

    public VendedoresModel(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    
}
