package com.revature.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
	@OneToMany(fetch = FetchType.EAGER)
	@JsonManagedReference(value = "customer-reservations")
	private List<Reservation> reservations;
}
