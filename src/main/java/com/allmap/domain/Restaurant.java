package com.allmap.domain;

import lombok.Data;

@Data
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private String youtuber;

    public Restaurant(Long id, String name, String address, String youtuber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.youtuber = youtuber;
    }
}
