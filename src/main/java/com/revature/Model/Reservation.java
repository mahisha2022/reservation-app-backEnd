package com.revature.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date reservation_time;

	@Column
	private int seats;

	@Column
	private String special_accommodations;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value = "restaurant-reservations")
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value = "customer-reservations")
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
