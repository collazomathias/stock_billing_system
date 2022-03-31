package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.facturas.FacturasDTO;
import uy.com.sofka.stockbilling.services.FacturasService;

@RestController
@CrossOrigin(origins = "*")
public class FacturasController {
    
    @Autowired
    private FacturasService facturasService;

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturasDTO> addNewBill(@RequestBody FacturasDTO facturasModel) {
        return this.facturasService.addNewBill(facturasModel);
    }

    @GetMapping("/facturas")
    @ResponseStatus(HttpStatus.OK)
    private Flux<FacturasDTO> getAllBills() {
        return this.facturasService.getAllBills();
    }

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<FacturasDTO> getBillById(@PathVariable("id") String id) {
        return this.facturasService.getBillById(id);
    }

    @DeleteMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturasDTO>> deleteBillById(@PathVariable("id") String id) {
        return this.facturasService.deleteBillById(id)
            .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturasDTO>> updateBillById(@PathVariable("id") String id, @RequestBody FacturasDTO facturasModel) {
        return this.facturasService.updateBillById(id, facturasModel)
            .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    
}
