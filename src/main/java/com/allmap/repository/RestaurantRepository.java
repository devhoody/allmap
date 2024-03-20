package com.allmap.repository;

import com.allmap.domain.Restaurant;

public interface RestaurantRepository {
    void save(Long restId, Restaurant restaurant);
    Restaurant findById(Long restId);
}
