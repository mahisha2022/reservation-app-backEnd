package com.revature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.revature.Repository.*;
import com.revature.Model.*;
import java.util.List;

@Service
@Transactional
public class CustomerService {
	CustomerRepository customerRepository;
	ReservationRepository reservationRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, ReservationRepository reservationRepository) {
		this.customerRepository = customerRepository;
		this.reservationRepository = reservationRepository;
	}

	public Customer newCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Reservation> getReservations() {
		return reservationRepository.findAll();
	}
}
