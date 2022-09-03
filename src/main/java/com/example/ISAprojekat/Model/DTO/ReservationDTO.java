package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.CottageReservation;
import com.example.ISAprojekat.Model.RegKorisnik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Long id;
    private String resName;
    private Date startDate;
    private Date endDate;
    private Long offerId;
    private Long korisnikId;
    private float price;
    private int duration;
    private int numPeople;

    public ReservationDTO(BoatReservation b) {
        this.id = b.getId();
        this.resName = b.getResName();
        this.startDate = b.getStartDate();
        this.endDate = b.getEndDate();
        this.offerId = b.getBoat().getId();
        this.korisnikId = b.getRegKorisnik().getId();
        this.duration = b.getDuration();
        this.price = b.getPrice();
        this.numPeople = b.getNumPeople();
    }
    public ReservationDTO(CottageReservation b) {
        this.resName = b.getResName();
        this.startDate = b.getStartDate();
        this.endDate = b.getEndDate();
        this.offerId = b.getCottage().getId();
        this.korisnikId = b.getRegKorisnik().getId();
        this.duration = b.getDuration();
        this.numPeople = b.getNumPeople();
    }

}
