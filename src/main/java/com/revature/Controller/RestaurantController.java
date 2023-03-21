package com.revature.Controller;
import com.revature.Model.Restaurant;
import com.revature.Service.ReservationService;
import com.revature.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    RestaurantService reservationService;


    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.reservationService = restaurantService;
    }

    /** 1. as a restaurant, I want to add/create restaurant
     * POST localhost/restaurant
     *
     * 2. as a restaurant, I want to update restaurant hours of operation, total seats address, or phone numbers
     * PATCH localhost:9000/restaurant/{id}
     *
     * 3. as a restaurant, I want to delete the restaurant
     * DELETE localhost:9000/restaurant/{id}
     *
     * as a restaurant, I want to see all reservations
     * GET localhost:9000/restaurant/reservations
     *
     *
     */

    @PostMapping("localhost/restaurant")
    public Restaurant postRestaurant(@RequestBody Restaurant restaurant){
        return reservationService.createRestaurant(restaurant);
    }

}
