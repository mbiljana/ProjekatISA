package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegKorisnik extends Korisnik {

        @OneToOne
        private BoatReservation boatReservation;
        @OneToOne
        private CottageReservation cottageReservation;








}
