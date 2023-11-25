package com.onlieshop.boot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String name;

    private String good;

    private Long quantity_of_goods;


    public Long getQuantity_of_goods() {
        return quantity_of_goods;
    }

    public void setQuantity_of_goods(Long quantity_of_goods) {
        this.quantity_of_goods = quantity_of_goods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }
}
