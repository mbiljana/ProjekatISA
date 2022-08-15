package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FastReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date startDate;
    @Column
    //duration in days
    private int duration;
    @Column
    private int capacity;
    @Column
    private String additionalServices;
    @Column
    private float price;
    @Column
    private String place;
    @Column
    private Boolean isCanceled = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private RentingEntity rentingEntity;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reg_user_id")
    private Client client;*/


    public FastReservation(Integer id, Date startDate, int duration, int capacity, String additionalServices, float price, String place, Boolean isCanceled, RentingEntity rentingEntity, Client client, Boat boat, Adventure adventure) {
        this.id = id;
        this.startDate = startDate;
        this.duration = duration;
        this.capacity = capacity;
        this.additionalServices = additionalServices;
        this.price = price;
        this.place = place;
        this.isCanceled = isCanceled;
        this.rentingEntity = rentingEntity;
        //this.client = client;
        this.boat = boat;
        this.adventure = adventure;
    }

    public FastReservation(Date startDate, int duration, int capacity, float price, RentingEntity rentingEntity) {
        this.startDate = startDate;
        this.duration = duration;
        this.capacity = capacity;
        this.price = price;
        this.rentingEntity = rentingEntity;
    }

    @ManyToOne
    private Boat boat;

    @ManyToOne
    private Adventure adventure;
    public Date getReservationEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getStartDate());
        cal.add(Calendar.HOUR_OF_DAY, this.getDuration());
        return cal.getTime();
    }

    public boolean overlapsWithExistingUnavailablePeriods(Set<UnavailablePeriod> unavailablePeriods) {
        for (UnavailablePeriod period : unavailablePeriods)
            if (period.getFromDateTime().before(this.getReservationEndTime()) && period.getToDateTime().after(this.getStartDate()))
                return true;

        return false;
    }

    public boolean overlapsWithExistingReservations(List<FastReservation> reservations) {
        for(FastReservation r : reservations)
            if (r.getStartDate().before(this.getReservationEndTime()) && r.getReservationEndTime().after(this.getStartDate()))
                return true;

        return false;
    }

    public boolean overlapsWithExistingSales(Set<Sale> sales) {
        for(Sale sale : sales)
            if (sale.getDateTimeFrom().before(this.getReservationEndTime()) && sale.getSaleEndTime().after(this.getStartDate()))
                return true;

        return false;
    }

    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "Reservation{}";
    }
}
