package com.restaurantapi.resrtaurantapi.repository;

import com.restaurantapi.resrtaurantapi.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, UUID> {
}
