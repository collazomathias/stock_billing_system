package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.vendedores.VendedoresDTO;

public interface VendedoresService {

    Mono<VendedoresDTO> addNewSeller(VendedoresDTO vendedoresDTO);
    Flux<VendedoresDTO> getAllSellers();
    Mono<VendedoresDTO> getSellerById(String id);
    Mono<VendedoresDTO> deleteSellerById(String id);
    Mono<VendedoresDTO> updateSellerById(String id, VendedoresDTO vendedoresDTO);
    
}
