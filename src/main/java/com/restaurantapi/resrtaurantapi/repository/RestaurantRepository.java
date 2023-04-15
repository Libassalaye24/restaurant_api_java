package com.restaurantapi.resrtaurantapi.repository;

import com.restaurantapi.resrtaurantapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

}
