package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boat  implements Serializable{

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
    @Column
    private String boatAddress;
    @Column
    private int boatCapacity;
    @Column
    private String boatRules;
    @Column
    private String boatDescription;
    @Column
    private String additionalEquipment;
    @Column
    private String navigationEquimpment;
    @Column
    private float latitude;
    @Column
    private float longitude;
    @Column
    private float price;
    @Column
    private String cancelCondition;
    @Column
    private String imageEnt1;
    @Column
    private String imageEnt2;
    @Column
    private String imageExt1;
    @Column
    private String imageExt2;



    @OneToOne
    private BoatReservation boatReservation;

    @ManyToOne
    private BoatOwner boatOwner;
    @OneToMany(mappedBy = "boat")
    private List<FastReservation> fastReservation = new ArrayList<>();
    @OneToMany(mappedBy = "boat")
    private List<Ocena> ocene = new ArrayList<>();

    public Boat(Long id, String boatName, String boatType, String engineNumber, String enginePower, int maxSpeed, String boatAddress, int boatCapacity, String boatRules, String boatDescription, String additionalEquipment, String navigationEquimpment, float latitude, float longitude, float price, String cancelCondition) {
        this.id = id;
        this.boatName = boatName;
        this.boatType = boatType;
        this.engineNumber = engineNumber;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.boatAddress = boatAddress;
        this.boatCapacity = boatCapacity;
        this.boatRules = boatRules;
        this.boatDescription = boatDescription;
        this.additionalEquipment = additionalEquipment;
        this.navigationEquimpment = navigationEquimpment;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.cancelCondition = cancelCondition;
    }


}
