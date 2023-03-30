package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class ReservationController {
	ReservationService reservationService;

	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@PostMapping(value = "reserve", params = {"customer", "venue"})
	public Reservation newReservation(@RequestParam("venue") long venue_id,
		@RequestParam("customer") long customer_id, @RequestBody Reservation reservation) {
		return reservationService.registerReservation(venue_id, customer_id, reservation);
	}

	@GetMapping(value = "reservations", params = {"customer"})
	public List<Reservation> getCustomerReservations(@RequestParam("customer") long customer_id) {
		return getCustomerReservations(customer_id);
	}

	@GetMapping(value = "reservations", params = {"restaurant"})
	public List<Reservation> getRestaurantReservations(@RequestParam("restaurant") long restaurant_id) {
		return getRestaurantReservations(restaurant_id);
	}
}
