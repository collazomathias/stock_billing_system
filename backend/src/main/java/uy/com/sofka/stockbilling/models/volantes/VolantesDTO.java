package uy.com.sofka.stockbilling.models.volantes;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.productos.ProductosModel;

public class VolantesDTO {
    
    private String idVolante;
    private String idProveedor;
    private String fechaVolante;
    private List<ProductosModel> listaProductos;

    public VolantesDTO(){}

    public VolantesDTO(String idProveedor, String fechaVolante, List<ProductosModel> listaProductos) {
        this.idProveedor = idProveedor;
        this.fechaVolante = fechaVolante;
        this.listaProductos = listaProductos;
    }

    public VolantesDTO VendedoresToDTO(VolantesModel volantesModel) {
        VolantesDTO volantesDTO = new VolantesDTO();
        volantesDTO.setFechaVolante(volantesModel.getFechaVolante());
        volantesDTO.setIdProveedor(volantesModel.getIdProveedor());
        volantesDTO.setIdVolante(volantesModel.getIdVolante());
        volantesDTO.setListaProductos(volantesModel.getListaProductos());
        return volantesDTO;
    }

    public Mono<VolantesDTO> VendedoresModelToDTO(Mono<VolantesModel> volantesModel) {
        return volantesModel.map(volante -> {
            VolantesDTO volantesDTO = new VolantesDTO();
            volantesDTO.setFechaVolante(volante.getFechaVolante());
            volantesDTO.setIdProveedor(volante.getIdProveedor());
            volantesDTO.setIdVolante(volante.getIdVolante());
            volantesDTO.setListaProductos(volante.getListaProductos());
            return volantesDTO;
        });
    }

    public Flux<VolantesDTO> VendedoresModelListToDTO(Flux<VolantesModel> volantesModel) {
        return volantesModel.map(volante -> {
            VolantesDTO volantesDTO = new VolantesDTO();
            volantesDTO.setFechaVolante(volante.getFechaVolante());
            volantesDTO.setIdProveedor(volante.getIdProveedor());
            volantesDTO.setIdVolante(volante.getIdVolante());
            volantesDTO.setListaProductos(volante.getListaProductos());
            return volantesDTO;
        });
    }

    public String getIdVolante() {
        return idVolante;
    }

    public String getFechaVolante() {
        return fechaVolante;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public List<ProductosModel> getListaProductos() {
        return listaProductos;
    }

    public void setIdVolante(String idVolante) {
        this.idVolante = idVolante;
    }

    public void setFechaVolante(String fechaVolante) {
        this.fechaVolante = fechaVolante;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setListaProductos(List<ProductosModel> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
