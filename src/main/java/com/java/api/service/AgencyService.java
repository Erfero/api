package com.java.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.api.model.Agency;
import com.java.api.repository.AgencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

      // Injection du dépôt AgencyRepository
      @Autowired
      private AgencyRepository agencyRepository;

      // Méthode pour obtenir toutes les agences
      public List<Agency> getAllAgencies() {
            return agencyRepository.findAll();
      }

      // Méthode pour obtenir une agence par son ID
      public Agency getAgencyById(Long id) {
            Optional<Agency> agencyData = agencyRepository.findById(id);

            if (agencyData.isPresent()) {
                  return agencyData.get();
            } else {
                  return null;
            }
      }

      // Méthode pour créer une nouvelle agence
      public Agency createAgency(Agency agency) {
            return agencyRepository.save(agency);
      }

      // Méthode pour mettre à jour une agence
      public Agency updateAgency(Long id, Agency agencyDetails) {
            Optional<Agency> agencyData = agencyRepository.findById(id);

            if (agencyData.isPresent()) {
                  Agency agency = agencyData.get();
                  agency.setName(agencyDetails.getName());
                  agency.setManager(agencyDetails.getManager());
                  agency.setOrders(agencyDetails.getOrders());
                  return agencyRepository.save(agency);
            } else {
                  return null;
            }
      }

      // Méthode pour supprimer une agence
      public void deleteAgency(Long id) {
            Optional<Agency> agencyData = agencyRepository.findById(id);

            if (agencyData.isPresent()) {
                  agencyRepository.deleteById(id);
            }
      }
}
