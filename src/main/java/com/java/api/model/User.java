package com.java.api.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insérez un nom d'utilisateur")
    @Size(min = 3, max = 50, message = "Saisisez au moins 3 caractères")
    private String username;

    @NotBlank(message = "Insérez un nom")
    @Size(min = 3, max = 50, message = "Saisisez au moins 3 caractères")
    private String firstname;

    @NotBlank(message = "Insérez un prenom")
    @Size(min = 3, max = 50, message = "Saisisez au moins 3 caractères")
    private String lastname;

    @Email(message = "email invalid")
    private String email;

    @NotBlank(message = "Insérez un mot de passe")
    private String password;

    // Annotation pour l'énumération du rôle de l'utilisateur
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Object getManagedAgencies() {
        return null;
    }

    public void setManagedAgencies(Object managedAgencies) {
    }

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agency> managedAgencies;
}
