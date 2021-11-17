package com.example.ISAprojekat.Model;


import javax.persistence.*;

@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String boatName;
    private String boatType;
    private String engineNumber;
    private String enginePower;
    private int maxSpeed;
    //navigaciona oprema ???
    private String boatAddress;
    private int boatCapacity;
    //termini
    private String boatRules;
    private String boatDescription;
    private String additionalEquipment;
    //cenovnik
    //private String dodatneUsluge; ???
    //uslovi otkaza rez
    @ManyToOne
    private BoatOwner boatOwner;

}
