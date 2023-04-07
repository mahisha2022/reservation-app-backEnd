package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.CustomerService;
import com.revature.Service.ReservationService;
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
public class ReservationController {
	ReservationService reservationService;
	RestaurantService restaurantService;
	CustomerService customerService;

	@Autowired
	public ReservationController(ReservationService reservationService, RestaurantService restaurantService, CustomerService customerService) {

		this.reservationService = reservationService;
		this.restaurantService =restaurantService;
		this.customerService = customerService;
	}

	/**
	 * Endpoint for POST localhost/reservations/customer/1/restaurant/1 adds a new resrvation
	 * for existed customer with id 1 and restaurant id 1
	 *{
	 *     {
	 *     "reservationDate": "2022-10-10",
	 *     "reservationTime": "09:30",
	 *     "seats": 9,
	 *     "name": "someone mm",
	 *     "contactInfo": "202-790-900",
	 *     "special_accommodations": "none"
	 * }
	 * should add new reservation with id 1 and response with
	 *
	 * {
	 *        "id": 1,
	 *     "reservationDate": "2022-10-10",
	 *     "reservationTime": "09:30",
	 *     "seats": 9,
	 *     "name": "someone mm",
	 *     "contactInfo": "202-790-900",
	 *     "special_accommodations": "none",
	 *     "customerId": 1,
	 *     "restaurantId": 1
	 * }
	 */
	@PostMapping("/reservations/customer/{customer_id}/restaurant/{restaurant_id}")
	public ResponseEntity<Reservation> postReservation(@PathVariable long customer_id, @PathVariable long restaurant_id,
														@RequestBody Reservation reservation){
		Reservation savedReservation = reservationService.registerReservation(reservation, customer_id, restaurant_id);
		return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
	}

	/**
	 * a request to GET localhost:9000/reservations/customer/1 could response
	 * {
	 *       {
	 *         "id": 1,
	 *         "reservationDate": "2023-10-10",
	 *         "reservationTime": "09:30",
	 *         "seats": 9,
	 *         "name": "someone mm",
	 *         "contactInfo": "202-790-900",
	 *         "special_accommodations": "none",
	 *         "customerId": 1,
	 *         "restaurantId": 1
	 *     }
	 * }
	 * @param customerId
	 * @return
	 */

	@GetMapping("/reservations/customer/{customerId}")
	public ResponseEntity<List<Reservation>> getCustomerReservation(@PathVariable Long customerId){

		Optional<Customer> optionalCustomer = customerService.getCustomerById(customerId);
		if(optionalCustomer.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		List<Reservation> reservations = reservationService.getCustomerReservations(optionalCustomer.get());
		return ResponseEntity.ok().body(reservations);
	}

	/**
	 * a request to GET localhost:9000/reservations/restaurant/1 could response
	 *  {
	 *         "id": 1,
	 *         "reservationDate": "2023-10-10",
	 *         "reservationTime": "09:30",
	 *         "seats": 9,
	 *         "name": "someone mm",
	 *         "contactInfo": "202-790-900",
	 *         "special_accommodations": "none",
	 *         "customerId": 1,
	 *         "restaurantId": 1
	 *     }
	 * @param restaurantId
	 * @return
	 */


	@GetMapping ("/reservations/restaurant/{restaurantId}")
	public ResponseEntity<List<Reservation>> getRestaurantReservation(@PathVariable Long restaurantId){
		Optional<Restaurant> optionalRestaurant = restaurantService.getRestaurantById(restaurantId);
		if(optionalRestaurant.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		List<Reservation> reservations = reservationService.getReservationByRestaurant(optionalRestaurant.get());
		return ResponseEntity.ok().body(reservations);
	}

	/**
	 * DELETE localhost:9000/reservations/1 could delete a reservation
	 * @param id
	 * @return
	 */

	@DeleteMapping("reservations/{id}")
	public Reservation deleteReservation(@PathVariable Long id){
		return reservationService.deleteReservation(id);
	}




}
