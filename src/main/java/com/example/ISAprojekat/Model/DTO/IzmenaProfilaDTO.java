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
    private String name;
    private String surname;
    private String homeAddress;
    private String emailAddress;
    private String password;
    private String city;
    private String state;
    private String username;
    private String phoneNumber;
}
