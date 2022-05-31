package com.example.ISAprojekat.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Admin extends Korisnik {
    public Admin() {
    }

    public Admin(Long id, String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super(id, name, surname, emailAddress, phoneNumber, city, state, homeAddress, birthDate, username, password, role);
    }

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<ZahtevZaReg> zahtevi = new ArrayList<>();
}
