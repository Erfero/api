package com.java.api.controller;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import com.java.api.model.Agency;
import com.java.api.service.AgencyService;

import java.util.List; 

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {

      // Annotation pour injecter automatiquement le service AgencyService
      @Autowired
      private AgencyService agencyService;

      // Méthode pour obtenir toutes les agences
      @GetMapping
      public List<Agency> getAllAgencies() {
            return agencyService.getAllAgencies();
      }

      // Méthode pour obtenir une agence par son ID
      @GetMapping("/{id}")
      public Agency getAgencyById(@PathVariable Long id) {
            return agencyService.getAgencyById(id);
      }

      // Méthode pour créer une nouvelle agence
      @PostMapping
      public Agency createAgency(@RequestBody Agency agency) {
            return agencyService.createAgency(agency);
      }

      // Méthode pour mettre à jour une agence
      @PutMapping("/{id}")
      public Agency updateAgency(@PathVariable Long id, @RequestBody Agency agencyDetails) {
            return agencyService.updateAgency(id, agencyDetails);
      }

      // Méthode pour supprimer une agence
      @DeleteMapping("/{id}")
      public void deleteAgency(@PathVariable Long id) {
            agencyService.deleteAgency(id);
      }
}
