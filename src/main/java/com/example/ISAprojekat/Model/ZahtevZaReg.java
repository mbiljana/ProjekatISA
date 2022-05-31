package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ZahtevZaReg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
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
    private Date birthDate;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String regType;
    @Column
    private String razlog;
    @ManyToOne
    private Admin admin;

}
