package com.restaurantapi.resrtaurantapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private BigDecimal prix;
    private String nom;
    private Boolean active;

    @JsonIgnore
    @ManyToMany(mappedBy = "produits")
    private List<Restaurant> restaurants;

    @JsonIgnore
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<DetailCommande> detailCommandes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<DetailCommande> getDetailCommandes() {
        return detailCommandes;
    }

    public void setDetailCommandes(List<DetailCommande> detailCommandes) {
        this.detailCommandes = detailCommandes;
    }
}
