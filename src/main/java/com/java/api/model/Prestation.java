package com.java.api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prestations")
public class Prestation {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Nom de la prestation avec une validation pour s'assurer qu'il n'est pas vide
      @NotBlank(message = "Le nom ne peut pas être vide")
      private String name;

      // Code de la prestation avec une validation pour s'assurer qu'il n'est pas vide
      @NotBlank(message = "Le code ne peut pas être vide")
      private String code;

      // Prix de la prestation avec une validation pour s'assurer qu'il n'est pas vide
      @NotNull(message = "Le prix ne peut pas être vide")
      private Double price;

}
