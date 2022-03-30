package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.ProveedoresModel;
import uy.com.sofka.stockbilling.repositories.ProveedoresRepository;
import uy.com.sofka.stockbilling.services.ProveedoresService;

@Service
public class ProveedoresServiceImplementation implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Override
    public Mono<ProveedoresModel> addNewSupplier(ProveedoresModel proveedoresModel) {
        return this.proveedoresRepository.save(proveedoresModel);
    }

    @Override
    public Flux<ProveedoresModel> getAllSuppliers() {
        return this.proveedoresRepository.findAll();
    }

    @Override
    public Mono<ProveedoresModel> getSupplierById(String id) {
        return this.proveedoresRepository.findByIdProveedor(id);
    }

    @Override
    public Mono<ProveedoresModel> deleteSupplierById(String id) {
        return this.proveedoresRepository.findByIdProveedor(id)
            .flatMap(proveedor -> proveedoresRepository.deleteById(proveedor.getIdProveedor())
            .thenReturn(proveedor));
    }

    @Override
    public Mono<ProveedoresModel> updateSupplierById(String id, ProveedoresModel proveedoresModel) {
        return this.proveedoresRepository.findByIdProveedor(id)
            .flatMap(proveedor -> {
                proveedoresModel.setIdProveedor(id);
                return addNewSupplier(proveedoresModel);
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
