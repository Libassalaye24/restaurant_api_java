package com.restaurantapi.resrtaurantapi.helper;

import com.restaurantapi.resrtaurantapi.exception.CommandeException;
import com.restaurantapi.resrtaurantapi.model.Commande;
import com.restaurantapi.resrtaurantapi.model.Produit;
import com.restaurantapi.resrtaurantapi.model.Restaurant;
import com.restaurantapi.resrtaurantapi.repository.CommandeRepository;
import com.restaurantapi.resrtaurantapi.repository.ProduitRepository;
import com.restaurantapi.resrtaurantapi.repository.RestaurantRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CreateCommandeHelper {

    private final CommandeRepository commandeRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProduitRepository produitRepository;


    public CreateCommandeHelper(CommandeRepository commandeRepository, RestaurantRepository restaurantRepository, ProduitRepository produitRepository) {
        this.commandeRepository = commandeRepository;
        this.restaurantRepository = restaurantRepository;
        this.produitRepository = produitRepository;
    }

    public Commande storeCommande(@RequestBody Commande commande){
        addCommandeToDetailCommande(commande);
       return commandeRepository.save(commande);
    }

    public List<Commande> getCommandes(){
        return commandeRepository.findAll();
    }

    public void addCommandeToDetailCommande(Commande commande){
        commande.setDetailCommandes(commande.getDetailCommandes().stream().map(detailCommande -> {
            detailCommande.setCommande(commande);
            return detailCommande;
        }).collect(Collectors.toList()));
    }

    public void checkAmountCommande(Commande commande){
        BigDecimal prix = commande.getDetailCommandes().stream().map(detailCommande -> {
            return detailCommande.getPrix().multiply(BigDecimal.valueOf(detailCommande.getQuantite()));
        }).reduce(BigDecimal.ZERO,BigDecimal::add);

        if (prix != null && prix.compareTo(commande.getPrix()) < 0) {
            throw new CommandeException("Prix invalide pour la commande");
        }

    }

    public void checkIfRestaurantExist(Restaurant restaurant){
        Optional <Restaurant> resto = restaurantRepository.findById(restaurant.getId());
        if (resto.isEmpty()){
            throw new CommandeException("restaurant avec l'id "+restaurant.getId()+" est introuvable");
        }

        if (!resto.get().isActive()){
            throw new CommandeException("restaurant avec l'id "+restaurant.getId()+" est inactif");
        }
    }

    public void checkProduitInRestaurant(Restaurant restaurant , List<Produit> produits){
        List<String> errorMessages = new ArrayList<>();
        produits.stream().map(produit -> {
            Produit p = produitRepository.findByRestaurantsAndId(restaurant , produit.getId());
            if(p == null){
                errorMessages.add("Produit avec id :"+produit.getId()
                        +" n'existe pas pour le restaurant avec id : "+restaurant.getId());
            }
            return produit;
        }).toList();

        if (!errorMessages.isEmpty()){
            throw new CommandeException(String.join("; ", errorMessages));
        }
    }

}
