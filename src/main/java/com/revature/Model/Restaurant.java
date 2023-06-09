package com.revature.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Restaurant extends User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long restaurantID;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String hoursOfOperation;
    @Column
    private int totalSeats;

    @OneToMany(mappedBy = "restaurant", fetch =  FetchType.EAGER )
    @JsonManagedReference(value = "restaurant-reservations")
    private List<Reservation> reservations;
}
