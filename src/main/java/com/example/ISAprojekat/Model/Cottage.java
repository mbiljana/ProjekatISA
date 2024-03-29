package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cottage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
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
    @Column
    private String cottageAdditionalServices;
    @Column
    private String cottageRules;
    @Column
    private float latitude;
    @Column
    private float longitude;
    @Column
    private float price;
    @Column
    private String cancelCondition;

    @ManyToOne
    private CottageOwner cottageOwner;
    @OneToMany(mappedBy = "cottage")
    private List<Ocena> ocene = new ArrayList<>();
    @OneToMany(mappedBy = "cottage")
    private List<FastReservationCott> fastReservations = new ArrayList<>();
    @OneToOne
    private CottageReservation cottageReservation;







}
