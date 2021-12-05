package com.example.ISAprojekat.Model;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class BoatOwner  extends Korisnik{
    public BoatOwner(Long id, String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super(id, name, surname, emailAddress, phoneNumber, city, state, homeAddress, birthDate, username, password, role);
    }




    public BoatOwner(String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super(name,surname,emailAddress,phoneNumber,city,state,homeAddress,birthDate,username,password,role);
    }

    public BoatOwner(String name, String surname, String emailAddress, String phoneNumber,  Date birthDate, String username, String password, Role role) {
        super(name,surname,emailAddress,phoneNumber,birthDate,username,password,role);
    }
}
