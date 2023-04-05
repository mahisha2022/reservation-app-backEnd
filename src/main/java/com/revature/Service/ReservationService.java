package com.revature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.Model.*;
import com.revature.Repository.*;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

	public Reservation registerReservation( Reservation reservation, long customer_id, long restaurant_id ) {
		Restaurant r = restaurantRepository.findById(restaurant_id).get();
		Customer c = customerRepository.findById(customer_id).get();
		reservation.setCustomer(c);
		reservation.setRestaurant(r);
		Reservation newReservation = reservationRepository.save(reservation);
		newReservation.setCustomerId(customer_id);
		newReservation.setRestaurantId(restaurant_id);
		return newReservation;
	}

	public List<Reservation> getCustomerReservations(Customer customer) {
		return reservationRepository.findAllByCustomer(customer);
	}

	public List<Reservation> getReservationByRestaurant(Restaurant restaurant){
		return reservationRepository.findAllByRestaurant(restaurant);
	}


	public Reservation deleteReservation(Long reservationId){
		Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
		Reservation reservation = reservationOptional.get();
		reservationRepository.delete(reservation);
		return reservation;
	}
}
