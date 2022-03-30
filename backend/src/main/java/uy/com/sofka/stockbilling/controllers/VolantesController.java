package uy.com.sofka.stockbilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uy.com.sofka.stockbilling.services.VolantesService;

@RestController
public class VolantesController {

    @Autowired
    private VolantesService volantesService;
    
}
