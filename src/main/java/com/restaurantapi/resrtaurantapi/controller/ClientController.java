package com.restaurantapi.resrtaurantapi.controller;

import com.restaurantapi.resrtaurantapi.model.Client;
import com.restaurantapi.resrtaurantapi.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/clients" ,produces = "application/vnd.api.v1+json")
@RestController
public class ClientController {


    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public Client save(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @GetMapping
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
