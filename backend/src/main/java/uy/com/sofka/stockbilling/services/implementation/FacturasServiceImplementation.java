package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.FacturasModel;
import uy.com.sofka.stockbilling.repositories.FacturasRepository;
import uy.com.sofka.stockbilling.services.FacturasService;

@Service
public class FacturasServiceImplementation implements FacturasService {

    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    public Mono<FacturasModel> addNewBill(FacturasModel facturasModel) {
        return this.facturasRepository.save(facturasModel);
    }

    @Override
    public Flux<FacturasModel> getAllBills() {
        return this.facturasRepository.findAll();
    }

    @Override
    public Mono<FacturasModel> getBillById(String id) {
        return this.facturasRepository.findByIdFactura(id);
    }

    @Override
    public Mono<FacturasModel> deleteBillById(String id) {
        return this.facturasRepository.findByIdFactura(id)
            .flatMap(factura -> this.facturasRepository.deleteById(factura.getIdFactura())
            .thenReturn(factura));
    }

    @Override
    public Mono<FacturasModel> updateBillById(String id, FacturasModel facturasModel) {
        return this.facturasRepository.findByIdFactura(id)
            .flatMap(factura -> {
                facturasModel.setIdFactura(id);
                return addNewBill(facturasModel);
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
