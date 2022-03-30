package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uy.com.sofka.stockbilling.services.ProveedoresService;

@RestController
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;
    
}
