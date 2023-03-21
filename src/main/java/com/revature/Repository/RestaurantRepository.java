package com.revature.Repository;

import com.revature.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findRestaurantByName(String restaurantName);

    Restaurant findRestaurantByAddress(String restaurantAddress);

    Restaurant deleteRestaurantById(Long restaurantID);

}
