package com.allmap.controller;

import com.allmap.domain.Restaurant;
import com.allmap.service.RestaurantService;
import com.allmap.service.RestaurantServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@NoArgsConstructor
@RequestMapping("/rest")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @GetMapping("list")
    public String list(Model model){
        List<Restaurant> restList = restaurantService.findAll();
        model.addAttribute("rests", restList);
        return "/rest/rests.html";
    }

    @GetMapping("add")
    public String add(){
        return "/rest/addRest.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("restName") String restName,
                      @RequestParam("address") String address,
                      @RequestParam("youtuber") String youtuber,
                      Model model){
        Restaurant restaurant = new Restaurant(restName,address,youtuber);
        restaurantService.reg(restaurant);

        log.info("저장된 식당정보 = " + restaurant.toString());

        return "redirect:./list";
    }



}
