package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private LocalDateTime dateFrom;
    //akcija kao boolean da li je na akciji ili ne ???
    //datum vazenja akcije
    private int numPeople;
    private String price;
    //proveriti tip trajanja
    private LocalTime duration;
    @Transient // ???
    private List<String> additionalServices = new ArrayList<String>() ;




}
