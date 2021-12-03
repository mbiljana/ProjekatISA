package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class BoatOwner  extends Korisnik implements Serializable {


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "boatOwner")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public List<Boat> boats = new ArrayList<>();


    public BoatOwner(String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super(name,surname,emailAddress,phoneNumber,city,state,homeAddress,birthDate,username,password,role);
    }
}
