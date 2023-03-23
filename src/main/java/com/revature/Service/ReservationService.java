package com.revature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.Model.*;
import com.revature.Repository.*;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {
	ReservationRepository reservationRepository;
	RestaurantRepository restaurantRepository;
	CustomerRepository customerRepository;

	@Autowired
	public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, CustomerRepository customerRepository) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.customerRepository = customerRepository;
	}

	public Reservation registerReservation(long restaurant_id, long customer_id, Reservation reservation) {
		Restaurant r = restaurantRepository.findById(restaurant_id).get();
		Customer c = customerRepository.findById(customer_id).get();
		r.getReservations().add(reservation);
		c.getReservations().add(reservation);
		return reservationRepository.save(reservation);
	}
}
