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
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private LocalDateTime datumOd;
    //akcija kao boolean da li je na akciji ili ne ???
    //datum vazenja akcije
    private int brojOsoba;
    private String cena;
    //proveriti tip trajanja
    private LocalTime trajanje;
    @Transient // ???
    private List<String> dodatneUsluge = new ArrayList<String>() ;




}
