package uy.com.sofka.stockbilling.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores")
public class ProveedoresModel {

    @Id
    private Long idProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private List<VolantesModel> listaVolantes;

    public ProveedoresModel(){}

    public ProveedoresModel(String nombreProveedor, String telefonoProveedor, List<VolantesModel> listaVolantes) {
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.listaVolantes = listaVolantes;
    }

    public Long getIdProveedor() {
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

    public void setIdProveedor(Long idProveedor) {
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
