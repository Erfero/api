package com.java.api.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "interventions")
public class Intervention {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Nom de l'intervention
      private String name;

      // Statut de l'intervention
      @Enumerated(EnumType.STRING)
      private InterventionStatus status;

      // Relation avec l'entité Order : une intervention est associée à une commande
      @OneToOne
      @JoinColumn(name = "order_id")
      private Order order;

      // Total de l'intervention
      private Double total;

      // Relation avec l'entité User : un expert est associé à chaque intervention
      @ManyToOne
      @JoinColumn(name = "expert_id")
      private User expert;

      // Date de création de l'intervention
      @Temporal(TemporalType.TIMESTAMP)
      private Date created;

}
