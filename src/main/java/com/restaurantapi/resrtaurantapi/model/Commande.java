package com.restaurantapi.resrtaurantapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private BigDecimal prix;
    @Enumerated(EnumType.STRING)
    @Column(name = "commande_statut")
    private CommandeStatut CommandeStatut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

//    @OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id")
    private AdresseDeLivraison adresseDeLivraison;


    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetailCommande> detailCommandes;

    @OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
    private Paiement paiement;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public CommandeStatut getCommandeStatut() {
        return CommandeStatut;
    }

    public void setCommandeStatut(CommandeStatut commandeStatut) {
        CommandeStatut = commandeStatut;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AdresseDeLivraison getAdresseDeLivraison() {
        return adresseDeLivraison;
    }

    public void setAdresseDeLivraison(AdresseDeLivraison adresseDeLivraison) {
        this.adresseDeLivraison = adresseDeLivraison;
    }

    public List<DetailCommande> getDetailCommandes() {
        return detailCommandes;
    }

    public void setDetailCommandes(List<DetailCommande> detailCommandes) {
        this.detailCommandes = detailCommandes;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}
