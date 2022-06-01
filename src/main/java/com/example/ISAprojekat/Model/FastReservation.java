package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FastReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date startDate;
    @Column
    //duration in days
    private int duration;
    @Column
    private int capacity;
    @Column
    private String additionalServices;
    @Column
    private String price;
    @Column
    private String place;
    @Column
    private String reservation;
    @ManyToOne
    private Boat boat;

    @ManyToOne
    private Adventure adventure;

}
