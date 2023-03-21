package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
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
	public List<Reservation> getReservationsByCustomer(@RequestParam("customer") long customer_id) {
		return reservationService.getAllReservationsByCustomer(customer_id);
	}

	@GetMapping(value = "reservations", params = {"venue"})
	public List<Reservation> getReservationsByVenue(@RequestParam("venue") long venue_id) {
		return reservationService.getAllReservationsByRestaurant(venue_id);
	}
}
