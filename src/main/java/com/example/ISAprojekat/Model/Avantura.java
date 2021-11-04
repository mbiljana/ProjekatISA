package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avantura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String nazivAvanture;
    private String adresaAvanture;
    private String promoOpis;
    private String biografijaInstruktora;
    private int kapacitet;
    private String pravilaPonasanjaAvanture;
    //termini;
    private String opremaAvanture;
    //cenovnik
    private String dodatneUslugeAvanture;
    //uslovi otkazivanja
    @ManyToOne
    private InstruktorPecanja instruktorPecanja;
}
