package uy.com.sofka.stockbilling.models;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores")
public class ProveedoresModel {

    @Id
    private String idProveedor = UUID.randomUUID().toString().substring(0, 10);
    private String nombreProveedor;
    private String telefonoProveedor;
    private List<VolantesModel> listaVolantes;

    public ProveedoresModel(){}

    public ProveedoresModel(String nombreProveedor, String telefonoProveedor, List<VolantesModel> listaVolantes) {
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.listaVolantes = listaVolantes;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public List<VolantesModel> getListaVolantes() {
        return listaVolantes;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public void setListaVolantes(List<VolantesModel> listaVolantes) {
        this.listaVolantes = listaVolantes;
    }
    
}
