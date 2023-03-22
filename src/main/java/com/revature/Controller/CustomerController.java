package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("register")
	public Customer newCustomer(@RequestBody Customer customer) {
		return customerService.newCustomer(customer);
	}
}
