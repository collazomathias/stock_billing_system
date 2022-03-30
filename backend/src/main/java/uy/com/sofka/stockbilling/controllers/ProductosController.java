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
import uy.com.sofka.stockbilling.models.ProductosModel;
import uy.com.sofka.stockbilling.services.ProductosService;

@RestController
@CrossOrigin(origins = "*")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProductosModel> addNewProduct(@RequestBody ProductosModel productosModel) {
        return this.productosService.addNewProduct(productosModel);
    }

    @GetMapping("/productos")
    @ResponseStatus(HttpStatus.OK)
    private Flux<ProductosModel> getAllProducts() {
        return this.productosService.getAllProducts();
    }

    @GetMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ProductosModel> getProductById(@PathVariable("id") String id) {
        return this.productosService.getProductById(id);
    }

    @DeleteMapping("/productos/{id}")
    private Mono<ResponseEntity<ProductosModel>> deleteProductById(@PathVariable("id") String id) {
        return this.productosService.deleteProductById(id)
            .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/productos/{id}")
    private Mono<ResponseEntity<ProductosModel>> updateProductById(@PathVariable("id") String id, @RequestBody ProductosModel productosModel) {
        return this.productosService.updateProductById(id, productosModel)
            .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
}
