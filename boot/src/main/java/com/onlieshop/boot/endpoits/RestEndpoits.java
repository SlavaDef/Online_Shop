package com.onlieshop.boot.endpoits;

import com.onlieshop.boot.entity.Shop;
import com.onlieshop.boot.repo.ShopsRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/new")
public class RestEndpoits {
    private final ShopsRepo shopsRepo;

    public RestEndpoits(ShopsRepo shopsRepo) {

        this.shopsRepo = shopsRepo;
    }

    @GetMapping("/shops")
    public Iterable<Shop> getShops() {
        return shopsRepo.findAll();
    }



}
