package uy.com.sofka.stockbilling.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.stockbilling.models.facturas.FacturasDTO;
import uy.com.sofka.stockbilling.models.facturas.FacturasModel;
import uy.com.sofka.stockbilling.repositories.FacturasRepository;
import uy.com.sofka.stockbilling.services.FacturasService;

@Service
public class FacturasServiceImplementation implements FacturasService {

    @Autowired
    private FacturasRepository facturasRepository;

    private FacturasDTO facturasDTO = new FacturasDTO();
    private FacturasModel facturasModel = new FacturasModel();

    @Override
    public Mono<FacturasDTO> addNewBill(FacturasDTO facturasDTO) {
        Mono<FacturasModel> newBill = facturasRepository.save(facturasModel.FacturasDTOToModel(facturasDTO));
        return facturasDTO.FacturasModelToDTO(newBill);
    }

    @Override
    public Flux<FacturasDTO> getAllBills() {
        Flux<FacturasModel> bills = facturasRepository.findAll();
        return facturasDTO.FacturasModelListToDTO(bills);
    }

    @Override
    public Mono<FacturasDTO> getBillById(String id) {
        Mono<FacturasModel> bill = facturasRepository.findByIdFactura(id);
        return facturasDTO.FacturasModelToDTO(bill);
    }

    @Override
    public Mono<FacturasDTO> deleteBillById(String id) {
        return this.facturasRepository.findByIdFactura(id)
            .flatMap(factura -> this.facturasRepository.deleteById(factura.getIdFactura())
            .thenReturn(facturasDTO.FacturasToDTO(factura)));
    }

    @Override
    public Mono<FacturasDTO> updateBillById(String id, FacturasDTO facturasDTO) {
        return this.facturasRepository.findByIdFactura(id)
            .flatMap(factura -> {
                factura.setIdFactura(id);
                factura.setFechaFactura(facturasDTO.getFechaFactura());
                factura.setListaProductos(facturasDTO.getListaProductos());
                factura.setNombreCliente(facturasDTO.getNombreCliente());
                factura.setVendedorFactura(facturasDTO.getVendedorFactura());
                factura.setPrecioTotal(facturasDTO.getPrecioTotal());
                return facturasDTO.FacturasModelToDTO(facturasRepository.save(factura));
            })
            .switchIfEmpty(Mono.empty());
    }
    
}
