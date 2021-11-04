package com.example.ISAprojekat.Model;


import javax.persistence.*;

@Entity
public class Brod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String nazivBroda;
    private String tip;
    private String brojMotora;
    private String snagaMotora;
    private int maksBrzina;
    //navigaciona oprema ???
    private String adresaBroda;
    private int kapacitetBroda;
    //termini
    private String pravilaPonasanjaBroda;
    private String opisBroda;
    private String dodatnaOprema;
    //cenovnik
    //private String dodatneUsluge; ???
    //uslovi otkaza rez
    @ManyToOne
    private VlasnikBroda vlasnikBroda;

}
