package com.example.ISAprojekat.Model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class RegKorisnik extends Korisnik implements Serializable {


    /*
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


     */






}
