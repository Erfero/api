package com.java.api.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.api.model.Prestation;
import com.java.api.repository.PrestationRepository;

import java.util.List;

@Service
public class PrestationService {

      // Définition des attributs
    @Autowired
    private PrestationRepository prestationRepository;

    // Méthode pour obtenir toutes les prestations
    public List<Prestation> getAllPrestations() {
        return prestationRepository.findAll();
    }

    // Méthode pour obtenir une prestation par son identifiant
    public Prestation getPrestationById(Long id) {
        return prestationRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter une prestation
    public Prestation createPrestation(Prestation prestation) {
        return prestationRepository.save(prestation);
    }

    // Méthode pour mettre à jour une prestation
    public Prestation updatePrestation(Long id, Prestation prestationDetails) {
        Prestation prestation = getPrestationById(id);
        if (prestation != null) {
            prestation.setName(prestationDetails.getName());
            prestation.setCode(prestationDetails.getCode());
            prestation.setPrice(prestationDetails.getPrice());
            return prestationRepository.save(prestation);
        }
        return null;
    }

    // méthode pour supprimer une prestation
    public void deletePrestation(Long id) {
        prestationRepository.deleteById(id);
    }
}
