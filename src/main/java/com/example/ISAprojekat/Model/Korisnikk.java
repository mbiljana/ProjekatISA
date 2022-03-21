package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//ovo je dodato
//proveriti da li je potrebno u nizim klasama dodati jos nesto

@Inheritance(strategy=JOINED)
public class Korisnikk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column (name = "ime")
    private String name;
    @Column
    private String surname;
    @Column
    private String emailAddress;
    @Column
    private String phoneNumber;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String homeAddress;
    @Column
    private Date birthDate; //mozda ne treba
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Role role;

    public Korisnikk(String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.homeAddress = homeAddress;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Korisnikk(String name, String surname, String emailAddress, String phoneNumber, Date birthDate, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
