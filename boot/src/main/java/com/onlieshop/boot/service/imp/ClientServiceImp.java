package com.onlieshop.boot.service.imp;

import com.onlieshop.boot.entity.Clients;
import com.onlieshop.boot.repo.ClientRepo;
import com.onlieshop.boot.service.ClientService;
import org.springframework.stereotype.Service;


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

    @Override
    public Clients deleteById(Long id) {
      Clients client =  clientRepo.findById(id).orElseThrow();
      clientRepo.delete(client);
      return client;

    }

    @Override
    public void saveClient(Clients client) {
        clientRepo.save(client);
    }

    @Override
    public boolean updateClient(Clients client,Long id) {
        if(clientRepo.findById(id).isPresent()){
            client.setId(id);
            clientRepo.save(client);
            return true;
        }
         return false;
    }

}
