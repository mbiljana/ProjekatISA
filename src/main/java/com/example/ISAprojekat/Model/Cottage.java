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
public class Cottage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private String cottageName;
    @Column
    private String cottageAddress;
    @Column
    private String cottageDescription;
    @Column
    private int numRooms;
    @Column
    private int numBeds;
    //cenovnik
    @Column
    private String cottageAdditionalServices;
    @Column
    private String cottageRules;
    //termini
    //vlasnik

    /*
    @ManyToOne
    private CottageOwner cottageOwner;

     */






}