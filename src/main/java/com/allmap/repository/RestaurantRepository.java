package com.allmap.repository;

import com.allmap.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    void save(Restaurant restaurant);

    Restaurant findById(Long restId);

    List<Restaurant> findByAll();
}
