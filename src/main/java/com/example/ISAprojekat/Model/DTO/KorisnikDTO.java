package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class KorisnikDTO {
    private Integer id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String username;
    private String password;
    private Timestamp lastPasswordResetDate;
    private Address address;
    private Uloga role;
    private UserStatus status;

    public KorisnikDTO(Integer id, String name, String surname, String phoneNumber, String emailAddress, String password, UserStatus userStatus, boolean enabled, Uloga uloga, Timestamp lastPasswordResetDate, Address address) {
    }
    public KorisnikDTO(Korisnik user){
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.emailAddress = user.getEmailAddress();
        this.phoneNumber = user.getPhoneNumber();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.lastPasswordResetDate = user.getLastPasswordResetDate();
        //this.address = user.getAddress();
        //this.role = user.getUloga();
        this.status = user.getUserStatus();
    }

    public KorisnikDTO(Integer id, String name, String surname, String emailAddress, String phoneNumber, String username, String password, Timestamp lastPasswordResetDate, Address address, Uloga role, UserStatus status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.address = address;
        this.role = role;
        this.status = status;
    }


    public KorisnikDTO(Integer id, String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
    }

    public KorisnikDTO(Integer id, String name, String surname, String phoneNumber, String emailAddress, String password, UserStatus userStatus, boolean enabled, Timestamp lastPasswordResetDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.role = role;
        this.status = status;
    }
}
