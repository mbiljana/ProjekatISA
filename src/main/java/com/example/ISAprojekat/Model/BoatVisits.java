package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.exception.DataException;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BoatVisits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int numberOfVisits;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;
    @ManyToOne
    private Boat boat;


    public BoatVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public BoatVisits(int numberOfVisits, Boat boat) {
        this.numberOfVisits = numberOfVisits;
        this.boat = boat;
    }

    public BoatVisits(int numberOfVisits, LocalDate startDate, LocalDate endDate, Boat boat) {
        this.numberOfVisits = numberOfVisits;
        this.startDate = startDate;
        this.endDate = endDate;
        this.boat = boat;
    }


}
