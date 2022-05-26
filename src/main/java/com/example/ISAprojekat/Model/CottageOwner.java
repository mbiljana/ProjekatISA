package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter


public class CottageOwner extends Korisnik {


    public CottageOwner(String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super( name, surname, emailAddress, phoneNumber, city, state, homeAddress, birthDate, username, password, role);
    }

    /*
    @OneToMany
    private List<Cottage> cottages = new ArrayList<>();

     */


}
