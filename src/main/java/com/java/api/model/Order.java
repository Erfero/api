package com.java.api.model;

// Importations nécessaires pour les annotations de persistance
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Nom de la commande
      private String name;

      // Statut de la commande
      @Enumerated(EnumType.STRING)
      private OrderStatus status;

      // Date de création de la commande
      @Temporal(TemporalType.TIMESTAMP)
      private Date created;

      // Date limite de la commande
      @Temporal(TemporalType.TIMESTAMP)
      private Date deadline;

      // Relation avec l'entité Agency : une agence peut avoir plusieurs commandes
      @ManyToOne
      @JoinColumn(name = "agency_id")
      private Agency agency;

      // Référence à l'entité Intervention : une commande est associée à une
      // intervention
      @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
      private Intervention intervention;

      @ManyToOne // Ceci suppose que plusieurs commandes peuvent être traitées par le même
                 // expert.
      @JoinColumn(name = "expert_id")
      private User expert; // Ajout d'un champ pour l'expert avec un User en tant qu'expert.

}