package com.onlieshop.boot.controllers;

import com.onlieshop.boot.entity.Clients;
import com.onlieshop.boot.service.imp.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/base")
public class ClientController {

    private final ClientServiceImp clientServiceImp;

    @Autowired
    public ClientController(ClientServiceImp clientServiceImp) {
        this.clientServiceImp = clientServiceImp;
    }

    @GetMapping // Clien Baze of USA
    public String simple() {
        return "Clien Base of USA";
    }

    // find all clients
    @GetMapping(value = "/clients")
    public Iterable<Clients> getAllClients() {
        return clientServiceImp.findAllClients();
    }

    // find client by id
    @GetMapping("/client/{id}")  // All work, don't forget about "/clients/{id}"
    public Clients getById(@PathVariable(value = "id") Long id) {
        return clientServiceImp.findClientById(id);
    }

    // Another case of realization method find client by id
    @GetMapping(value = "/client2/{id}")
    public ResponseEntity<Clients> read(@PathVariable(name = "id") Long id) {
        final Clients client = clientServiceImp.findClientById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete Client by id
    @PostMapping(value = "/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        clientServiceImp.deleteById(id);

        return "client sucsesfully has been deleted";
    }

    // Another case of realization method deleteClient
    @PostMapping(value = "/delete2/{id}")
    public ResponseEntity<Clients> delete(@PathVariable(name = "id") Long id) {
        final Clients client = clientServiceImp.deleteById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // save new client
    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody Clients client) {
        clientServiceImp.saveClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, Clients client,
                                    @RequestParam Date date,
                                    @RequestParam String name,
                                    @RequestParam String good,
                                    @RequestParam Long quantity_of_goods) {

        client = clientServiceImp.findClientById(id);
        client.setDate(date);
        client.setName(name);
        client.setGood(good);
        client.setQuantity_of_goods(quantity_of_goods);

        //  clientServiceImp.updateClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // update client
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update2(@PathVariable(name = "id") Long id, @RequestBody Clients client) {
        final boolean updated = clientServiceImp.updateClient(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
}
