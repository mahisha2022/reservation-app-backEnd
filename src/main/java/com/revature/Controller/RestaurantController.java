package com.revature.Controller;
import com.revature.Model.Restaurant;
import com.revature.Service.ReservationService;
import com.revature.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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

    /**
     * POST localhost:9000/restaurant
     * @param restaurant
     * @return
     */
    @PostMapping("restaurant")
    public Restaurant postRestaurant(@RequestBody Restaurant restaurant, @RequestParam String username,
                                     @RequestParam String password){
       Restaurant newRestaurant = reservationService.createRestaurant(username, password, restaurant);

       return newRestaurant;
    }

    /**
     * GET localhost:9000/restaurant
     */
    @GetMapping("restaurant")
    public List<Restaurant> getAllRestaurant(){
        return reservationService.getAllRestaurant();
    }

    /**
     * GET localhost:9000/restaurant/{name}
     */
    @GetMapping("restaurant/{name}")
    public List<Restaurant> getRestaurantByName(@PathVariable String name){
        return reservationService.getRestaurantByName(name);
    }

    /**
     * GET localhost:9000/restaurant/{address}
     */
    @GetMapping("restaurant/{address}")
    public List<Restaurant>  getRestaurantByAddress(@PathVariable String address){
        return reservationService.getRestaurantByAddress(address);
    }
    /**
     * DELETE localhost:9000/restaurant/{id}
     */

    @DeleteMapping("restaurant/{id}")
    public Restaurant deleteRestaurantById(@PathVariable long id){
        return reservationService.deleteRestaurantById(id);
    }

    /**
     * PATCH localhost:9000/restaurant/{id}
     */

    @PatchMapping("restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable long id, @RequestBody Restaurant restaurant){
        return reservationService.updateRestaurantById(id, restaurant);
    }

}
