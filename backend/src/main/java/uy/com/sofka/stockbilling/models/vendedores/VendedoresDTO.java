package uy.com.sofka.stockbilling.models.vendedores;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VendedoresDTO {
    
    private String idVendedor;
    private String nombreVendedor;
    
    public VendedoresDTO(){}

    public VendedoresDTO(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public VendedoresDTO VendedoresToDTO(VendedoresModel vendedoresModel) {
        VendedoresDTO vendedoresDTO = new VendedoresDTO();
        vendedoresDTO.setIdVendedor(vendedoresModel.getIdVendedor());
        vendedoresDTO.setNombreVendedor(vendedoresModel.getNombreVendedor());
        return vendedoresDTO;
    }

    public Mono<VendedoresDTO> VendedoresModelToDTO(Mono<VendedoresModel> vendedoresModel) {
        return vendedoresModel.map(vendedor -> {
            VendedoresDTO vendedoresDTO = new VendedoresDTO();
            vendedoresDTO.setIdVendedor(vendedor.getIdVendedor());
            vendedoresDTO.setNombreVendedor(vendedor.getNombreVendedor());
            return vendedoresDTO;
        });
    }

    public Flux<VendedoresDTO> VendedoresModelListToDTO(Flux<VendedoresModel> vendedoresModel) {
        return vendedoresModel.map(vendedor -> {
            VendedoresDTO vendedoresDTO = new VendedoresDTO();
            vendedoresDTO.setIdVendedor(vendedor.getIdVendedor());
            vendedoresDTO.setNombreVendedor(vendedor.getNombreVendedor());
            return vendedoresDTO;
        });
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
