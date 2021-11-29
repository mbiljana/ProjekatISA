package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class BoatAppointment extends Appointment implements Serializable {

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser reservedBoat;
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser visitedBoat;

     */
}
