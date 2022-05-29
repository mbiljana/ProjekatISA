package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adventure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private String adventureName;
    @Column
    private String adventureAddress;
    @Column
    private String promoDescription;
    @Column
    private String instructorBiography;
    @Column
    private int adventureCapacity;
    @Column
    private String adventureRules;
    //termini;
    @Column
    private String aventureEquipment;
    //cenovnik
    @Column
    private String adventureAdditionalServices;


    //uslovi otkazivanja

    /*
    @ManyToOne
    private FishingInstructor fishingInstructor;
*/

}
