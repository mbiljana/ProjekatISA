package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table

public class CottageAppointment extends Appointment implements Serializable {

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser reservedCottages;
    @ManyToOne(fetch = FetchType.EAGER)
    private RegUser visitedCottages;

     */
}
