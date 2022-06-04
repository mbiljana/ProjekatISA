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

    @ManyToOne
    private BoatOwner boatOwner;
    @OneToMany(mappedBy = "boat")
    private List<FastReservation> fastReservation = new ArrayList<>();
    @OneToMany(mappedBy = "boat")
    private List<Ocena> ocene = new ArrayList<>();



}
