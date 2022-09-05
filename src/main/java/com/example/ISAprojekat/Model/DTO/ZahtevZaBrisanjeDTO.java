package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZahtevZaBrisanjeDTO {
    Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String username;
    private boolean blocked;

}
