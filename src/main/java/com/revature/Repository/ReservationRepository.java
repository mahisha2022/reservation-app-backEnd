package com.revature.Repository;

import com.revature.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findAllByCustomer(Customer customer);
	List<Reservation> findAllByRestaurant(Restaurant restaurant);
}
