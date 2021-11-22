package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private String boatName;
    @Column
    private String boatType;
    @Column
    private String engineNumber;
    @Column
    private String enginePower;
    @Column
    private int maxSpeed;
    //navigaciona oprema ???
    @Column
    private String boatAddress;
    @Column
    private int boatCapacity;
    //termini
    @Column
    private String boatRules;
    @Column
    private String boatDescription;
    @Column
    private String additionalEquipment;
    //cenovnik
    //private String dodatneUsluge; ???
    //uslovi otkaza rez

   /*
    @ManyToOne
    private BoatOwner boatOwner;

    */

}
