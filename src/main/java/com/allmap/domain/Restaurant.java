package com.allmap.domain;

import lombok.Data;

@Data
public class Restaurant {
    private Long id;
    private String restName;
    private String address;
    private String youtuber;

    public Restaurant() {
    }

    public Restaurant(String restName, String address, String youtuber) {
        this.restName = restName;
        this.address = address;
        this.youtuber = youtuber;
    }
}
