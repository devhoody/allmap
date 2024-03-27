package com.allmap.repository;

import com.allmap.domain.Restaurant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryRestaurantRepositoryTest {

    private MemoryRestaurantRepository restaurantRepository = new MemoryRestaurantRepository();

    @AfterEach
    void clear() {
        restaurantRepository.clear();
    }

    @Test
    @DisplayName("식당 저장 성공")
    void 식당저장() {
        //given
        Restaurant restaurant = new Restaurant(1L, "평양냉면", "마포구", "먹을텐데");
        //when
        restaurantRepository.save(restaurant);
        Restaurant findRestaurant = restaurantRepository.findById(1L);
        //then
        assertThat(findRestaurant.getName()).isEqualTo("평양냉면");
    }

    @Test
    void findById() {
    }

    @Test
    @DisplayName("모든 식당 출력")
    void 식당리스트출력() {
        //given
        Restaurant restaurant1 = new Restaurant(1L, "restA", "마포구", "호사장");
        Restaurant restaurant2 = new Restaurant(2L, "restB", "마포구", "호사장");
        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);

        //when
        List<Restaurant> list = restaurantRepository.findByAll();

        //then
        assertThat(list.size()).isEqualTo(2);
    }
}