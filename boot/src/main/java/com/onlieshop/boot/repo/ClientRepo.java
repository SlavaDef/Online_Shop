package com.onlieshop.boot.repo;

import com.onlieshop.boot.entity.Clients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepo extends CrudRepository<Clients,Long> {

    @Query("select distinct c.name from Clients c where c.date > '2000-01-01'") // return all names after date > '2000-01-01'
    public Iterable<Clients> findAllByNames();

    @Query("select name from Clients") // return all names
    public Iterable<Clients> findAllByNames2();

    @Query("from Clients where id>5")
    public Iterable<Clients> findAllByIds(); // return all поля

    @Query("from Clients where id=5")
    public Iterable<Clients> findAllByOddIds(); //

    @Query("select good from Clients") // return all goods
    public Iterable<String> findAllBygood();




}

