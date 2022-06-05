package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoatReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String resName;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private int duration;
    @OneToOne
    private Boat boat;
    @OneToOne
    private RegKorisnik regKorisnik;
}
