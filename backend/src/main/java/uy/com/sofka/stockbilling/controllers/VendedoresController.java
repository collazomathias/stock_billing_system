package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import uy.com.sofka.stockbilling.services.VendedoresService;

@RestController
@CrossOrigin(origins = "*")
public class VendedoresController {

    @Autowired
    private VendedoresService vendedoresService;
    
}
