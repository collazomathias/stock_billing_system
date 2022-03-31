package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.vendedores.VendedoresDTO;
import uy.com.sofka.stockbilling.models.vendedores.VendedoresModel;
import uy.com.sofka.stockbilling.repositories.VendedoresRepository;
import uy.com.sofka.stockbilling.services.VendedoresService;

@Service
public class VendedoresServiceImplementation implements VendedoresService {
    
    @Autowired
    private VendedoresRepository vendedoresRepository;

    private VendedoresDTO vendedoresDTO = new VendedoresDTO();
    private VendedoresModel vendedoresModel = new VendedoresModel();

    @Override
    public Mono<VendedoresDTO> addNewSeller(VendedoresDTO vendedores) {
        Mono<VendedoresModel> newSeller = vendedoresRepository.save(vendedoresModel.VendedoresDTOToModel(vendedores));
        return vendedoresDTO.VendedoresModelToDTO(newSeller);
    }

    @Override
    public Flux<VendedoresDTO> getAllSellers() {
        Flux<VendedoresModel> sellers = vendedoresRepository.findAll();
        return vendedoresDTO.VendedoresModelListToDTO(sellers);
    } 

    @Override
    public Mono<VendedoresDTO> getSellerById(String id) {
        Mono<VendedoresModel> seller = vendedoresRepository.findByIdVendedor(id);
        return vendedoresDTO.VendedoresModelToDTO(seller);
    }

    @Override
    public Mono<VendedoresDTO> deleteSellerById(String id) {
        return this.vendedoresRepository.findByIdVendedor(id)
            .flatMap(vendedor -> vendedoresRepository.deleteById(vendedor.getIdVendedor())
            .thenReturn(vendedoresDTO.VendedoresToDTO(vendedor)));
    }

    @Override
    public Mono<VendedoresDTO> updateSellerById(String id, VendedoresDTO vendedores) {
        return this.vendedoresRepository.findByIdVendedor(id)
            .flatMap(vendedor -> {
                vendedor.setIdVendedor(id);
                vendedor.setNombreVendedor(vendedores.getNombreVendedor());
                return vendedoresDTO.VendedoresModelToDTO(vendedoresRepository.save(vendedor));
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
