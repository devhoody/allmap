package com.allmap.repository;

import com.allmap.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryRestaurantRepository implements RestaurantRepository {

    private Map<Long, Restaurant> store = new HashMap<>();
    private static long sequence = 0L; //static


    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant.setId(++sequence);
        store.put(restaurant.getId(), restaurant);
        return store.get(restaurant.getId());
    }

    @Override
    public Restaurant findById(Long restId) {
        return store.get(restId);
    }

    @Override
    public List<Restaurant> findByAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Restaurant edit(Restaurant restaurant) {
        Restaurant restaurant1 = store.get(restaurant.getId());
        restaurant1.setRestName(restaurant.getRestName());
        restaurant1.setAddress(restaurant.getAddress());
        restaurant1.setYoutuber(restaurant.getYoutuber());
        store.put(restaurant.getId(), restaurant1);
        return restaurant1;
    }

    public void clear() {
        store.clear();
    }
}
