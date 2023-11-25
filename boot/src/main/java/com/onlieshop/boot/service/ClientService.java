package com.onlieshop.boot.service;

import com.onlieshop.boot.entity.Clients;

import java.util.Optional;

public interface ClientService {

    public Iterable<Clients> findAllClients();

    public Clients findClientById(Long id);

    public Clients deleteById(Long id);

    public void saveClient(Clients clients);

    public boolean updateClient(Clients client,Long id);
}
