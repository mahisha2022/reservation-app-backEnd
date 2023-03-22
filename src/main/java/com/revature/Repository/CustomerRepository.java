package com.revature.Repository;

import com.revature.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByUsernameAndPasswd(String username, String passwd);
}
