package com.java.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.java.api.model.Prestation;
import com.java.api.service.PrestationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestations")
public class PrestationController {
    @Autowired
    private PrestationService prestationService;

    @GetMapping()
    public Iterable<Prestation> getAllPrestations() {
        return prestationService.getAllPrestations();
    }


    @GetMapping("/{id}")
    public Prestation getPrestationById(@PathVariable Long id) {
          return prestationService.getPrestationById(id);
    }

    @PostMapping()
    public Prestation createPrestation(@RequestBody Prestation prestation) {
          return prestationService.createPrestation(prestation);
    }

    @PutMapping("/{id}")
    public Prestation updatePrestation(@PathVariable Long id, @RequestBody Prestation prestation) {
          return prestationService.updatePrestation(id, prestation);
    }

    @DeleteMapping("/{id}")
      public void deletePrestations(@PathVariable Long id) {
            prestationService.deletePrestation(id);
      } 
}