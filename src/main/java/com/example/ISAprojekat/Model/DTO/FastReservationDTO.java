package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Model.FastReservationCott;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FastReservationDTO {
    private Long boatId;
    private String resName;
    private Date startDate;
    private int duration;
    private int capacity;
    private String additionalServices;
    private float price;

    public FastReservationDTO(FastReservation b) {
        this.boatId = b.getBoat().getId();
        this.resName = b.getResName();
        this.startDate = b.getStartDate();
        this.duration = b.getDuration();
        this.capacity = b.getCapacity();
        this.additionalServices = b.getAdditionalServices();
        this.price = b.getPrice();
    }

    public FastReservationDTO(FastReservationCott b) {
        this.boatId = b.getCottage().getId();
        this.resName = b.getResName();
        this.startDate = b.getStartDate();
        this.duration = b.getDuration();
        this.capacity = b.getCapacity();
        this.additionalServices = b.getAdditionalServices();
        this.price = b.getPrice();
    }
}
