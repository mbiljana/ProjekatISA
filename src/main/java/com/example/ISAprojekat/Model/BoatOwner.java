package com.example.ISAprojekat.Model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
@Getter
@Setter
public class BoatOwner  extends Korisnik {

    public BoatOwner( String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super( name, surname, emailAddress, phoneNumber, city, state, homeAddress, birthDate, username, password, role);
    }

    public BoatOwner() {

    }
}
