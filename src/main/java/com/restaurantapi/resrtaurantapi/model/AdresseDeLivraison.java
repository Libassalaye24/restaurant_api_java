package com.restaurantapi.resrtaurantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adressedelivraison")
public class AdresseDeLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String rue;
    @Column(name = "code_postal")
    private String codepostal;
    private String ville;

    @JsonIgnore
    @OneToMany(mappedBy = "adresseDeLivraison")
    private List<Commande> commandes;
}
