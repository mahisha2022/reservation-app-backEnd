package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class CustomerController {
	CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("customer/register")
	public Customer newCustomer(@RequestBody Customer customer) {
		return customerService.newCustomer(customer);
	}

	@PostMapping("customer/login")
	public Customer loginCustomer(@RequestBody Customer customer) {
		return customerService.login(customer);
	}

	@GetMapping("customer/{id}/reservations")
	public List<Reservation> getCustomerReservations(@PathVariable("id") long id) {
		return customerService.getReservations(id);
	}
}
