package com.java.api.model;


import lombok.Data;
import jakarta.persistence.*;
import java.util.*;

@Data
@Entity
// Annotation pour spécifier le nom de la table correspondante dans la base de données
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom de l'agence
    private String name;

    // Relation avec l'entité User : un utilisateur peut gérer plusieurs agences
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    // Liste des commandes associées à cette agence
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

}

