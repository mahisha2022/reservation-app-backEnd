package com.revature.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    @Column
    private String restaurantName;
    @Column
    private  String restaurantAddress;
    @Column
    private  String restaurantPhone;
    @Column
    private String hoursOfOperation;
    @Column
    private String totalSeats;


    @OneToMany(fetch =  FetchType.EAGER)
    @JsonManagedReference
    private List<Reservation> reservations;

    public Restaurant(Long restaurantId, String restaurantName,
                      String restaurantAddress, String restaurantPhone, String hoursOfOperation) {
    }
}


