package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Appointment;
import com.example.ISAprojekat.Model.FishingInstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    Long id;
    private LocalDateTime dateFrom;
    private String place;
    private String additionalServices;
    private int numPeople;
    private String price;
    private LocalTime duration;

    public AppointmentDTO(Appointment a) {
        this.id = a.getId();
        this.additionalServices = a.getAdditionalServices();
        this.dateFrom = a.getDateFrom();
        this.duration = a.getDuration();
        this.numPeople = a.getNumPeople();
        this.price = a.getPrice();
        this.place = a.getPlace();

    }

    public AppointmentDTO(FishingInstructor a) {

    }
}
