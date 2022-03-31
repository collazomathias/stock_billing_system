package uy.com.sofka.stockbilling.models.proveedores;

import java.util.List;

import uy.com.sofka.stockbilling.models.volantes.VolantesModel;

public class ProveedoresDTO {
    
    private String nombreProveedor;
    private String telefonoProveedor;
    private List<VolantesModel> listaVolantes;

    public ProveedoresDTO(){}

    public ProveedoresDTO(String nombreProveedor, String telefonoProveedor, List<VolantesModel> listaVolantes) {
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.listaVolantes = listaVolantes;
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
