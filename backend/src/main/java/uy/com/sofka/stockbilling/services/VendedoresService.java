package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.VendedoresModel;

public interface VendedoresService {

    Mono<VendedoresModel> addNewSeller(VendedoresModel vendedoresModel);
    Flux<VendedoresModel> getAllSellers();
    Mono<VendedoresModel> getSellerById(String id);
    Mono<VendedoresModel> deleteSellerById(String id);
    Mono<VendedoresModel> updateSellerById(String id, VendedoresModel vendedoresModel);
    
}
