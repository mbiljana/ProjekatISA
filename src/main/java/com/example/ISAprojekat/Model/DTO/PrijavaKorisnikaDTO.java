package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrijavaKorisnikaDTO {
    private Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String city;
    private String state;
    private String homeAddress;
    private Date birthDate; //mozda ne treba
    private String username;
    private String password;
    private Role role;

    public PrijavaKorisnikaDTO(Long id, String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        this.id = id;
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

    public PrijavaKorisnikaDTO(String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
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

    public PrijavaKorisnikaDTO() {
    }

  /*  public PrijavaKorisnikaDTO(Korisnik a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.emailAddress = a.getEmailAddress();
        this.phoneNumber = a.getPhoneNumber();
        this.city = a.getCity();
        this.state = a.getState();
        this.homeAddress = a.getHomeAddress();
        this.birthDate = a.getBirthDate();
        this.username = a.getUsername();
        this.password = a.getPassword();
        this.role = a.getRole();
    }*/
}