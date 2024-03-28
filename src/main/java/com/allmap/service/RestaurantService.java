package com.allmap.service;

import com.allmap.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    void reg(Restaurant restaurant);
    Restaurant findById(Long restaurantId);

    List<Restaurant> findAll();
}
