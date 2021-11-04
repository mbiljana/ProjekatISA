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
public class Vikendica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String nazivVikendice;
    private String adresaVikendice;
    private String opisVikendice;
    private int brojSoba;
    private int brojKreveta;
    //cenovnik
    private String dodatneUsluge;
    private String pravilaPonasanja;
    //termini
    //vlasnik
    @ManyToOne
    private VlasnikVikendice vlasnikVikendice;

}
