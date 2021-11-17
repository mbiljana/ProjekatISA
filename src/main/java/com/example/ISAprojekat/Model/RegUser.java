package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegUser extends User {

    @OneToMany(mappedBy = "reservedCottages",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public List<CottageAppointment> reservedCottages = new ArrayList<>();

    @OneToMany(mappedBy = "visitedCottages",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public List<CottageAppointment> visitedCottages = new ArrayList<>();

    @OneToMany(mappedBy = "reservedBoats",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public List<BoatAppointment> reservedBoats = new ArrayList<>();

    @OneToMany(mappedBy = "visitedBoats",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public List<BoatAppointment> visitedBoats = new ArrayList<>();

    @OneToMany(mappedBy = "reservedAdventure",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public List<AdventureAppointment> reservedAdventure = new ArrayList<>();

    @OneToMany(mappedBy = "visitedAdventure",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public List<AdventureAppointment> visitedAdventure = new ArrayList<>();







}
