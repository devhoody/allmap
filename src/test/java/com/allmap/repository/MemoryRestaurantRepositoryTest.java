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
        Restaurant restaurant = new Restaurant("평양냉면", "마포구", "먹을텐데");
        //when
        Restaurant savedRest = restaurantRepository.save(restaurant);
        Restaurant findRestaurant = restaurantRepository.findById(savedRest.getId());
        //then
        assertThat(findRestaurant.getRestName()).isEqualTo("평양냉면");
    }

    @Test
    @DisplayName("식당아이디별조회")
    void 식당아이디별조회() {
        //given
        Restaurant restaurant = new Restaurant("평양냉면", "마포구", "먹을텐데");
        Restaurant savedRest = restaurantRepository.save(restaurant);
        Long id = savedRest.getId();

        //when
        Restaurant findRest = restaurantRepository.findById(id);

        //then
        assertThat(findRest.getRestName()).isEqualTo(restaurant.getRestName());
    }

    @Test
    @DisplayName("모든 식당 출력")
    void 식당리스트출력() {
        //given
        Restaurant restaurant1 = new Restaurant("restA", "마포구", "호사장");
        Restaurant restaurant2 = new Restaurant("restB", "마포구", "호사장");
        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);

        //when
        List<Restaurant> list = restaurantRepository.findByAll();

        //then
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("식당수정")
    void edit() {
        //given
        Restaurant restaurant1 = new Restaurant("restA", "마포구", "호사장");
        Restaurant savedRest = restaurantRepository.save(restaurant1);
        savedRest.setRestName("restB");
        savedRest.setYoutuber("먹을텐데");
        savedRest.setAddress("서울시");
        //when
        Restaurant editRest = restaurantRepository.edit(savedRest);

        //then
        assertThat(editRest.getRestName()).isEqualTo("restB");
        assertThat(editRest.getAddress()).isEqualTo("서울시");
        assertThat(editRest.getYoutuber()).isEqualTo("먹을텐데");
    }
}