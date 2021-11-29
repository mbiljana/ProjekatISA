package com.example.ISAprojekat.Model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class BoatOwner  extends Korisnik implements Serializable {


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "boatOwner")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public List<Boat> boats = new ArrayList<>();





}
