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
@AllArgsConstructor
@NoArgsConstructor
public class FastReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private RentingEntity rentingEntity;


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

    @Override
    public String toString() {
        return "Reservation{}";
    }
}
