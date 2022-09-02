package com.example.ISAprojekat.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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


    //lista termina
    @OneToMany(mappedBy = "adventure")
    private List<Appointment> freeAppointments = new ArrayList<>();


    @ManyToOne
    private FishingInstructor fishingInstructor;

    public Adventure(Long id, String adventureName, String adventureAddress, String promoDescription, String instructorBiography, int adventureCapacity, String adventureRules, String aventureEquipment, String adventureAdditionalServices) {
    }

    public Adventure(String adventureName, String adventureAddress, String promoDescription, String instructorBiography, int adventureCapacity, String adventureRules, String aventureEquipment, String adventureAdditionalServices) {
    }
}
