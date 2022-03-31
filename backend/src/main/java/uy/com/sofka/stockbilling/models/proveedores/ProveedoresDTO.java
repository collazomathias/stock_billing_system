package uy.com.sofka.stockbilling.models.proveedores;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.volantes.VolantesModel;

public class ProveedoresDTO {
    
    private String idProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private List<VolantesModel> listaVolantes;

    public ProveedoresDTO(){}

    public ProveedoresDTO(String nombreProveedor, String telefonoProveedor, List<VolantesModel> listaVolantes) {
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.listaVolantes = listaVolantes;
    }

    public ProveedoresDTO ProductosToDTO(ProveedoresModel proveedoresModel) {
        ProveedoresDTO proveedoresDTO = new ProveedoresDTO();
        proveedoresDTO.setIdProveedor(proveedoresModel.getIdProveedor());
        proveedoresDTO.setListaVolantes(proveedoresModel.getListaVolantes());
        proveedoresDTO.setNombreProveedor(proveedoresModel.getNombreProveedor());
        proveedoresDTO.setTelefonoProveedor(proveedoresModel.getTelefonoProveedor());
        return proveedoresDTO;
    }

    public Mono<ProveedoresDTO> ProductosModelToDTO(Mono<ProveedoresModel> proveedoresModel) {
        return proveedoresModel.map(proveedor -> {
            ProveedoresDTO proveedoresDTO = new ProveedoresDTO();
            proveedoresDTO.setIdProveedor(proveedor.getIdProveedor());
            proveedoresDTO.setListaVolantes(proveedor.getListaVolantes());
            proveedoresDTO.setNombreProveedor(proveedor.getNombreProveedor());
            proveedoresDTO.setTelefonoProveedor(proveedor.getTelefonoProveedor());
            return proveedoresDTO;
        });
    }

    public Flux<ProveedoresDTO> ProductosModelListToDTO(Flux<ProveedoresModel> proveedoresModel) {
        return proveedoresModel.map(proveedor -> {
            ProveedoresDTO proveedoresDTO = new ProveedoresDTO();
            proveedoresDTO.setIdProveedor(proveedor.getIdProveedor());
            proveedoresDTO.setListaVolantes(proveedor.getListaVolantes());
            proveedoresDTO.setNombreProveedor(proveedor.getNombreProveedor());
            proveedoresDTO.setTelefonoProveedor(proveedor.getTelefonoProveedor());
            return proveedoresDTO;
        });
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
