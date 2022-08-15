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

    public AppointmentDTO(Long id, LocalDateTime dateFrom, String place, String additionalServices, int numPeople, String price, LocalTime duration) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.place = place;
        this.additionalServices = additionalServices;
        this.numPeople = numPeople;
        this.price = price;
        this.duration = duration;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
