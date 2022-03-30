package uy.com.sofka.stockbilling.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.FacturasModel;

public interface FacturasService {

    Mono<FacturasModel> addNewBill(FacturasModel facturasModel);
    Flux<FacturasModel> getAllBills();
    Mono<FacturasModel> getBillById(String id);
    Mono<FacturasModel> deleteBillById(String id);
    Mono<FacturasModel> updateBillById(String id, FacturasModel facturasModel);
    
}
