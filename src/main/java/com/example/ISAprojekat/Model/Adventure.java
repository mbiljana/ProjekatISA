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
public class Adventure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String adventureName;
    private String adventureAddress;
    private String promoDescription;
    private String instructorBiography;
    private int adventureCapacity;
    private String adventureRules;
    //termini;
    private String aventureEquipment;
    //cenovnik
    private String adventureAdditionalServices;
    //uslovi otkazivanja
    @ManyToOne
    private FishingInstructor fishingInstructor;
}
