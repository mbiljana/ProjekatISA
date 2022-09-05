package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ZahtevZaBrisanje {

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
    private String username;
    @Column
    private boolean blocked;

    @ManyToOne
    private Admin admin;
}
