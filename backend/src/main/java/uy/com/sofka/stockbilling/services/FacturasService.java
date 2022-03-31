package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.facturas.FacturasDTO;

public interface FacturasService {

    Mono<FacturasDTO> addNewBill(FacturasDTO facturasModel);
    Flux<FacturasDTO> getAllBills();
    Mono<FacturasDTO> getBillById(String id);
    Mono<FacturasDTO> deleteBillById(String id);
    Mono<FacturasDTO> updateBillById(String id, FacturasDTO facturasModel);
    
}
