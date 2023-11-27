package com.onlieshop.boot.controllers;

import com.onlieshop.boot.entity.Clients;
import com.onlieshop.boot.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baze2")
public class ControllerForQuery {

    private final ClientRepo clientRepo;
    @Autowired
    public ControllerForQuery(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    @GetMapping("/goods")
    public Iterable<String> findAllGoods(){
        return clientRepo.findAllBygood();
    }

    @GetMapping("/id")
    public Iterable<Clients> findAllOddId(){
        return clientRepo.findAllByOddIds();
    }

    @GetMapping("/noOdd")
    public Iterable<Clients> findAllNoOddId(){
        return clientRepo.findAllByNoOddId();
    }

    @GetMapping("/odd")
    public Iterable<Clients> getOddClients(){ // without Iterable does'not work
        return clientRepo.findAllByIds();
    }


}
