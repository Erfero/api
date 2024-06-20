package com.java.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.api.model.Intervention;
import com.java.api.repository.InterventionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InterventionService {

      @Autowired
      private InterventionRepository interventionRepository;

      // Récupérer toutes les interventions
      public List<Intervention> getAllInterventions() {
            return interventionRepository.findAll();
      }

      public Intervention getInterventionById(Long id) {
            Optional<Intervention> interventionData = interventionRepository.findById(id);

            if (interventionData.isPresent()) {
                  return interventionData.get();
            } else {
                  return null;
            }
      }

      // Créer une nouvelle intervention
      public Intervention createIntervention(Intervention intervention) {
            return interventionRepository.save(intervention);
      }

      // Mettre à jour une intervention existante
      public Optional<Intervention> updateIntervention(Long id, Intervention interventionDetails) {
            return interventionRepository.findById(id)
                        .map(intervention -> {
                              intervention.setName(interventionDetails.getName());
                              intervention.setStatus(interventionDetails.getStatus());
                              intervention.setOrder(interventionDetails.getOrder());
                              intervention.setTotal(interventionDetails.getTotal());
                              intervention.setExpert(interventionDetails.getExpert());
                              intervention.setCreated(interventionDetails.getCreated());
                              return interventionRepository.save(intervention);
                        });
      }

      // Supprimer une intervention
      public void deleteIntervention(Long id) {
            if (interventionRepository.existsById(id)) {
                  interventionRepository.deleteById(id);
            }
      }
}
