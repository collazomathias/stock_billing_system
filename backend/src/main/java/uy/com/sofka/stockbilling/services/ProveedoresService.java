package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.proveedores.ProveedoresModel;

public interface ProveedoresService {

    Mono<ProveedoresModel> addNewSupplier(ProveedoresModel proveedoresModel);
    Flux<ProveedoresModel> getAllSuppliers();
    Mono<ProveedoresModel> getSupplierById(String id);
    Mono<ProveedoresModel> deleteSupplierById(String id);
    Mono<ProveedoresModel> updateSupplierById(String id, ProveedoresModel proveedoresModel);
    
}
