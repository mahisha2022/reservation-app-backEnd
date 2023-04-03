package com.revature.Service;

import com.revature.Model.*;
import com.revature.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Create restaurant
     * @param restaurant
     * @return
     */
    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }


    /**
     * get all restaurant
     * @return
     */
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public List<Reservation> getReservations(long id){
        return restaurantRepository.findById(id).get().getReservations();
    }

    /**
     * getRestaurant by name
     */

    public List<Restaurant> getRestaurantsByName(String name){
        return restaurantRepository.findAllByName(name);
    }

    /**
     * Delete restaurant
     */

    public Restaurant deleteRestaurantById(Long restaurantId){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantOptional.get();
        restaurantRepository.delete(restaurant);
        return restaurant;
    }

    /**
     * update Restaurant by Id
     */
    public Restaurant updateRestaurantById(long restaurantId, Restaurant updatedRestaurant){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        restaurant.setName(updatedRestaurant.getName());
        restaurant.setAddress(updatedRestaurant.getAddress());
        restaurant.setPhone(updatedRestaurant.getPhone());
        restaurant.setHoursOfOperation(updatedRestaurant.getHoursOfOperation());
        return  restaurant;
    }

    public List<Restaurant> getRestaurantsByAddress(String address) {
        return restaurantRepository.findAllByAddress(address);
    }

    public Optional<Restaurant> getRestaurantById(long id){
        return restaurantRepository.findById(id);
    }
}
