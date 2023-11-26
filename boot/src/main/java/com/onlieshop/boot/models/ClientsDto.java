package com.onlieshop.boot.models;

import lombok.Data;

import java.util.Date;

@Data
public class ClientsDto {
    private Date date;

    private String name;

    private String good;

    private Long quantity_of_goods;
}
