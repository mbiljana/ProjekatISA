package com.example.ISAprojekat.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FastReservationCott implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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
    @ManyToOne
    private Cottage cottage;
}
