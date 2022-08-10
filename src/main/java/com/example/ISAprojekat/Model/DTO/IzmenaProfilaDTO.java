package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IzmenaProfilaDTO {
    private Integer id;
    private String name;
    private String surname;
    private String homeAddress;
    private String emailAddress;
    private String password;
    private String city;
    private String state;
    private String username;
    private String phoneNumber;



    public IzmenaProfilaDTO( String name, String surname, String homeAddress, String emailAddress, String password, String city, String state, String username, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
        this.password = password;
        this.city = city;
        this.state = state;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}
