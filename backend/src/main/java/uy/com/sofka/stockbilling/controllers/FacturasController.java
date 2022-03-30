package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.FacturasModel;
import uy.com.sofka.stockbilling.services.FacturasService;

@RestController
public class FacturasController {
    
    @Autowired
    private FacturasService facturasService;

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturasModel> addNewBill(@RequestBody FacturasModel facturasModel) {
        return this.facturasService.addNewBill(facturasModel);
    }

    @GetMapping("/facturas")
    @ResponseStatus(HttpStatus.OK)
    private Flux<FacturasModel> getAllBills() {
        return this.facturasService.getAllBills();
    }

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<FacturasModel> getBillById(@PathVariable("id") String id) {
        return this.facturasService.getBillById(id);
    }

    
}
