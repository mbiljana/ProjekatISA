package com.example.ISAprojekat.Model.DTO;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZahtevDTO {
    private Long idKorisnika;
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
    private String regType;
    private String razlog;
}
