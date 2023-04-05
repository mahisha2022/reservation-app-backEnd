package com.revature.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date reservationDate;

	@Column
//	@DateTimeFormat(pattern = "HH:mm:ss")
	private String reservationTime;

	@Column
	private int seats;

	@Column
	private String name;

	@Column
	private String contactInfo;

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

	@Column(name= "customer_id", insertable = false, updatable = false)
	private long customerId;

	@Column(name = "restaurant_id", insertable = false, updatable = false)
	private long restaurantId;
}
