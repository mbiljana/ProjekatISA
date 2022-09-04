package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegKorisnik extends Korisnik {

        @OneToMany(mappedBy = "regKorisnik")
        private List<BoatReservation> boatReservation;
        @OneToMany(mappedBy = "regKorisnik")
        private List<CottageReservation> cottageReservation;








}
