package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrijavaKorisnikaDTO {
    private Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String city;
    private String state;
    private String homeAddress;
    private Date birthDate;
    private String username;
    private String password;
    private Role role;



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




}
