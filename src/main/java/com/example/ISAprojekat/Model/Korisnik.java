package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String ime;
    private String prezime;
    private String emailAdresa;
    private int brojTelefona;
    private String grad;
    private String drzava;
    private String adresaPrebivalista;
    private Date datumRodjenja; //mozda ne treba
    private String korisnickoIme;
    private String lozinka;



}
