package com.allmap.service;

import com.allmap.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant reg(Restaurant restaurant);

    Restaurant findById(Long restaurantId);

    List<Restaurant> findAll();

    Restaurant edit(Restaurant restaurant);
}
