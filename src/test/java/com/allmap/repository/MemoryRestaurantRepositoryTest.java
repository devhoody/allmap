package com.allmap.repository;

import com.allmap.domain.Restaurant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryRestaurantRepositoryTest {

    private MemoryRestaurantRepository restaurantRepository= new MemoryRestaurantRepository();

    @AfterEach
    void clear(){
        restaurantRepository.clear();
    }

    @Test
    @DisplayName("식당 저장 성공")
    void 식당저장() {
        //given
        Restaurant restaurant = new Restaurant(1L,"평양냉면","마포구","먹을텐데");
        //when
        restaurantRepository.save(1L, restaurant);
        Restaurant findRestaurant = restaurantRepository.findById(1L);
        //then
        Assertions.assertThat(findRestaurant.getName()).isEqualTo("평양냉면");
    }

    @Test
    void findById() {
    }
}