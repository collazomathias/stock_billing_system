package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.proveedores.ProveedoresDTO;

public interface ProveedoresService {

    Mono<ProveedoresDTO> addNewSupplier(ProveedoresDTO proveedoresDTO);
    Flux<ProveedoresDTO> getAllSuppliers();
    Mono<ProveedoresDTO> getSupplierById(String id);
    Mono<ProveedoresDTO> deleteSupplierById(String id);
    Mono<ProveedoresDTO> updateSupplierById(String id, ProveedoresDTO proveedoresDTO);
    
}
