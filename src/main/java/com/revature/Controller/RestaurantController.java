package com.revature.Controller;
import com.revature.Exceptions.InvalidInputException;
import com.revature.Model.*;
import com.revature.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@CrossOrigin("*")
public class RestaurantController {

    RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
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
    @PostMapping("restaurant/register")
    public Restaurant newRestaurant(@RequestBody Restaurant restaurant){
       return restaurantService.createRestaurant(restaurant);
    }

    /**
     * GET localhost:9000/restaurant
     */
    @GetMapping("restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("restaurant/{id}/reservations")
    public List<Reservation> getReservations(@PathVariable long id){
        return restaurantService.getReservations(id);
    }

    /**
     * GET localhost:9000/restaurant/{name}
     */
    @GetMapping("restaurant/name/{name}")
    public List<Restaurant> getRestaurantsByName(@PathVariable String name){
        return restaurantService.getRestaurantsByName(name);
    }

    /**
     * GET localhost:9000/restaurant/{address}
     */
    @GetMapping("restaurant/address/{address}")
    public List<Restaurant>  getRestaurantsByAddress(@PathVariable String address){
        return restaurantService.getRestaurantsByAddress(address);
    }
    /**
     * DELETE localhost:9000/restaurant/{id}
     */

    @DeleteMapping("restaurant/{id}")
    public Restaurant deleteRestaurantById(@PathVariable long id){
        return restaurantService.deleteRestaurantById(id);
    }

    /**
     * PATCH localhost:9000/restaurant/{id}
     */

    @PatchMapping("restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable long id, @RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurantById(id, restaurant);
    }

    @GetMapping("restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable long id){
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping("restaurant/login")
    public ResponseEntity<?> restaurantLogin(@RequestBody Restaurant restaurant) throws InvalidInputException {

        try {
            Restaurant restaurant1 = restaurantService.restaurantLogin(restaurant.getUsername(), restaurant.getPasswd());
            return  ResponseEntity.ok(restaurant1);
        } catch (InvalidInputException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password or username");
        }

    }
}
