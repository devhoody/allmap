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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                      RedirectAttributes redirectAttributes){
        Restaurant restaurant = new Restaurant(restName,address,youtuber);
        Restaurant savedRestaurant = restaurantService.reg(restaurant);

        redirectAttributes.addAttribute("restId", savedRestaurant.getId());
        redirectAttributes.addAttribute("status", true);

        log.info("저장된 식당정보 = " + restaurant.toString());

        return "redirect:/rest/{restId}";
    }

    @GetMapping("{restId}")
    public String rest(@PathVariable Long restId, Model model){
        Restaurant findRestaurant = restaurantService.findById(restId);
        model.addAttribute("rest", findRestaurant);
        return "rest/rest";
    }



}
