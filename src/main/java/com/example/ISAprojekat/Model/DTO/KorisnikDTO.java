package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KorisnikDTO {
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

    public KorisnikDTO(Korisnik a) {
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
    }
}
