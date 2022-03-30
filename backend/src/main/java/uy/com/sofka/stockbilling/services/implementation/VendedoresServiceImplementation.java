package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.VendedoresModel;
import uy.com.sofka.stockbilling.repositories.VendedoresRepository;
import uy.com.sofka.stockbilling.services.VendedoresService;

@Service
public class VendedoresServiceImplementation implements VendedoresService {
    
    @Autowired
    private VendedoresRepository vendedoresRepository;

    @Override
    public Mono<VendedoresModel> addNewSeller(VendedoresModel vendedoresModel) {
        return this.vendedoresRepository.save(vendedoresModel);
    }

    @Override
    public Flux<VendedoresModel> getAllSellers() {
        return this.vendedoresRepository.findAll();
    } 

    @Override
    public Mono<VendedoresModel> getSellerById(String id) {
        return this.vendedoresRepository.findByIdVendedor(id);
    }

    @Override
    public Mono<VendedoresModel> deleteSellerById(String id) {
        return this.vendedoresRepository.findByIdVendedor(id)
            .flatMap(vendedor -> vendedoresRepository.deleteById(vendedor.getIdVendedor())
            .thenReturn(vendedor));
    }

    @Override
    public Mono<VendedoresModel> updateSellerById(String id, VendedoresModel vendedoresModel) {
        return this.vendedoresRepository.findByIdVendedor(id)
            .flatMap(vendedor -> {
                vendedoresModel.setIdVendedor(id);
                return addNewSeller(vendedoresModel);
            })
            .switchIfEmpty(Mono.empty());
    }

}
