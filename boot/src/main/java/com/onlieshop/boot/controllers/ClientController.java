package com.onlieshop.boot.controllers;

import com.onlieshop.boot.entity.Clients;
import com.onlieshop.boot.service.imp.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/new")
public class ClientController {

    private final ClientServiceImp clientServiceImp;
    @Autowired
    public ClientController(ClientServiceImp clientServiceImp) {
        this.clientServiceImp = clientServiceImp;
    }

    @GetMapping // Clien Baze of USA
    public String simple(){
        return "Clien Baze of USA";
    }

    // find all clients
    @GetMapping(value = "/clients")
    public Iterable<Clients> getAllClients() {
        return clientServiceImp.findAllClients();
    }

    // find client by id
    @GetMapping("/clients/{id}")  // All work, don't forget about "/clients/{id}"
    public Clients getById(@PathVariable(value = "id") Long id){
        return clientServiceImp.findClientById(id);    }

    // Another case of realization method find client by id
    @GetMapping(value = "/clients2/{id}")
    public ResponseEntity<Clients> read(@PathVariable(name = "id") Long id) {
        final Clients client = clientServiceImp.findClientById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
