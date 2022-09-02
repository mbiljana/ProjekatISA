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
    private String resName;
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
    private float price;
    @Column
    private String place;
    @ManyToOne
    private Boat boat;

}
