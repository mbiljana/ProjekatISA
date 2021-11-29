package com.example.ISAprojekat.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class BoatOwner  extends Korisnik implements Serializable {


    @OneToMany(mappedBy = "boatOwner",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Boat> boats = new ArrayList<>();





}
