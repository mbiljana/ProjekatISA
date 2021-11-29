package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private LocalDateTime dateFrom;
    //akcija kao boolean da li je na akciji ili ne ???
    //datum vazenja akcije
    @Column
    private int numPeople;
    @Column
    private String price;
    //proveriti tip trajanja
    @Column
    private LocalTime duration;
   /* @Transient // ???
    private List<String> additionalServices = new ArrayList<String>() ;


    */



}
