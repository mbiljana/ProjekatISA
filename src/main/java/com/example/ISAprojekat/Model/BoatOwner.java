package com.example.ISAprojekat.Model;


import javax.persistence.Entity;
import java.io.Serializable;


@Entity
public class BoatOwner extends Korisnik implements Serializable {

    /*

    @OneToMany(mappedBy = "boatOwner",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Boat> boats = new ArrayList<>();


     */

}
