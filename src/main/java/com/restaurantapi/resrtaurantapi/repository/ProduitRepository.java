package com.restaurantapi.resrtaurantapi.repository;

import com.restaurantapi.resrtaurantapi.model.Produit;
import com.restaurantapi.resrtaurantapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, UUID> {
    public Produit findByRestaurantsAndId(Restaurant restaurant, UUID id);
}
