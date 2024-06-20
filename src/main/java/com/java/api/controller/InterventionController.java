package com.java.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.api.model.Intervention;
import com.java.api.service.InterventionService;


@RestController
@RequestMapping("/interventions")
public class InterventionController {
    

    @Autowired
    private InterventionService interventionService;

    @GetMapping()
    public Iterable<Intervention> getAllinterventions() {
        return interventionService.getAllInterventions();
    }


    @GetMapping("/{id}")
    public Intervention getInterventionById(@PathVariable Long id) {
          return interventionService.getInterventionById(id);
    }

    @PostMapping()
    public Intervention createIntervention(@RequestBody Intervention intervention) {
          return interventionService.createIntervention(intervention);
    }

    @PutMapping("/{id}")
    public Optional<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention interventionDetail) {
          return interventionService.updateIntervention(id, interventionDetail);
    }

    @DeleteMapping("/{id}")
      public void deleteIntervention(@PathVariable Long id) {
            interventionService.deleteIntervention(id);
      }
}

