package com.onlieshop.boot.service.imp;

import com.onlieshop.boot.entity.Clients;
import com.onlieshop.boot.repo.ClientRepo;
import com.onlieshop.boot.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepo clientRepo;


    public ClientServiceImp(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Iterable<Clients> findAllClients(){
       return clientRepo.findAll();
    }

    @Override
    public Clients findClientById(Long id) {
        return clientRepo.findById(id).orElseThrow(IllegalStateException::new);

    }

    public Optional<Clients> findClientById2(Long id) {
        return clientRepo.findById(id);
        //  return clientRepo.findById(id).orElseThrow();
    }
}
