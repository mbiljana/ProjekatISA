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
public class AdventureAppointment extends Appointment  {

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser reservedAdventure;
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser visitedAdventure;

     */

}
