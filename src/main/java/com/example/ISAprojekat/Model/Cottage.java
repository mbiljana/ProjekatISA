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
    private String cottageName;
    private String cottageAddress;
    private String cottageDescription;
    private int numRooms;
    private int numBeds;
    //cenovnik
    private String cottageAdditionalServices;
    private String cottageRules;
    //termini
    //vlasnik
    @ManyToOne
    private CottageOwner cottageOwner;

}
