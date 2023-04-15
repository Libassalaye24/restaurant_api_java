package com.restaurantapi.resrtaurantapi.controller;

import com.restaurantapi.resrtaurantapi.helper.CreateCommandeHelper;
import com.restaurantapi.resrtaurantapi.model.Commande;
import com.restaurantapi.resrtaurantapi.repository.CommandeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/commandes" )
@RestController
public class CommandeController {

    private final CreateCommandeHelper createCommandeHelper;

    public CommandeController(CreateCommandeHelper createCommandeHelper) {
        this.createCommandeHelper = createCommandeHelper;
    }

    @PostMapping
    public Commande save(@RequestBody Commande commande){
        return createCommandeHelper.storeCommande(commande);
    }

    @GetMapping
    public List<Commande> findAll(){
        return createCommandeHelper.getCommandes();
    }
}
