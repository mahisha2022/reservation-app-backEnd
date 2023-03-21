package com.revature.Service;


import com.revature.Model.Restaurant;
import com.revature.Repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RestaurantService {
    RestaurantRepository restaurantRepository;
    UserService userService;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Create restaurant
     * @param restaurant
     * @return
     */
   public Restaurant createRestaurant(String username, String password, Restaurant restaurant){
     boolean userAuthenticated = userService.userAuthenticate(username, password);
     if(!userAuthenticated){
         return null;
     }
     Restaurant newRestaurant = restaurantRepository.save(restaurant);
     return newRestaurant;

   }


    /**
     * get all restaurant
     * @return
     */
   public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
   }

    /**
     * getRestaurant by name
     */

    public List<Restaurant> getRestaurantByName(String name){
        return restaurantRepository.findRestaurantByName(name);
    }

    /**
     * Delete restaurant
     */

    public Restaurant deleteRestaurantById(Long restaurantId){
        return restaurantRepository.deleteRestaurantById(restaurantId);
    }

    /**
     * update Restaurant by Id
     */
    public Restaurant updateRestaurantById(long restaurantId, Restaurant updatedRestaurant){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantOptional.get();
        restaurant.setRestaurantAddress(updatedRestaurant.getRestaurantAddress());
        restaurant.setRestaurantPhone(updatedRestaurant.getRestaurantPhone());
        restaurant.setHoursOfOperation(updatedRestaurant.getHoursOfOperation());

        return  restaurant;
    }


    public List<Restaurant> getRestaurantByAddress(String address) {
        return restaurantRepository.findRestaurantByAddress(address);
    }


}
