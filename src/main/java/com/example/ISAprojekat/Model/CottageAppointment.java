package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CottageAppointment extends Appointment{

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser reservedCottages;
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser visitedCottages;

     */
}
