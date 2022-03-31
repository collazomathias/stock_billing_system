package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.proveedores.ProveedoresDTO;
import uy.com.sofka.stockbilling.models.proveedores.ProveedoresModel;
import uy.com.sofka.stockbilling.repositories.ProveedoresRepository;
import uy.com.sofka.stockbilling.services.ProveedoresService;

@Service
public class ProveedoresServiceImplementation implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    private ProveedoresDTO proveedoresDTO = new ProveedoresDTO();
    private ProveedoresModel proveedoresModel = new ProveedoresModel();

    @Override
    public Mono<ProveedoresDTO> addNewSupplier(ProveedoresDTO proveedores) {
        Mono<ProveedoresModel> newSupplier = proveedoresRepository.save(proveedoresModel.ProveedoresDTOToModel(proveedores));
        return proveedoresDTO.ProductosModelToDTO(newSupplier);
    }

    @Override
    public Flux<ProveedoresDTO> getAllSuppliers() {
        Flux<ProveedoresModel> suppliers = proveedoresRepository.findAll();
        return proveedoresDTO.ProductosModelListToDTO(suppliers);
    }

    @Override
    public Mono<ProveedoresDTO> getSupplierById(String id) {
        Mono<ProveedoresModel> supplier = proveedoresRepository.findByIdProveedor(id);
        return proveedoresDTO.ProductosModelToDTO(supplier);
    }

    @Override
    public Mono<ProveedoresDTO> deleteSupplierById(String id) {
        return this.proveedoresRepository.findByIdProveedor(id)
            .flatMap(proveedor -> proveedoresRepository.deleteById(proveedor.getIdProveedor())
            .thenReturn(proveedoresDTO.ProductosToDTO(proveedor)));
    }

    @Override
    public Mono<ProveedoresDTO> updateSupplierById(String id, ProveedoresDTO proveedores) {
        return this.proveedoresRepository.findByIdProveedor(id)
            .flatMap(proveedor -> {
                proveedor.setIdProveedor(id);
                proveedor.setNombreProveedor(proveedores.getNombreProveedor());
                proveedor.setTelefonoProveedor(proveedores.getTelefonoProveedor());
                proveedor.setListaVolantes(proveedores.getListaVolantes());
                return proveedoresDTO.ProductosModelToDTO(proveedoresRepository.save(proveedor));
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
