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

    @Override
    public void save(Restaurant restaurant) {
        store.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant findById(Long restId) {
        return store.get(restId);
    }

    @Override
    public List<Restaurant> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
