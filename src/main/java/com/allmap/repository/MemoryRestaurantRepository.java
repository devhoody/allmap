package com.allmap.repository;

import com.allmap.domain.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class MemoryRestaurantRepository implements RestaurantRepository{

    private Map<Long, Restaurant> store = new HashMap<>();
    @Override
    public void save(Long restId, Restaurant restaurant) {
        store.put(restId, restaurant);
    }

    @Override
    public Restaurant findById(Long restId) {
        return store.get(restId);
    }

    public void clear(){
        store.clear();
    }
}
