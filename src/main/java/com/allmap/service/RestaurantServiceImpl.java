package com.allmap.service;

import com.allmap.domain.Restaurant;
import com.allmap.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant reg(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findByAll();
    }

    @Override
    public Restaurant edit(Restaurant restaurant) {
        return restaurantRepository.edit(restaurant);
    }
}
