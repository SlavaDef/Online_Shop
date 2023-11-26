package com.onlieshop.boot.repo;

import com.onlieshop.boot.entity.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Clients,Long> {



}
