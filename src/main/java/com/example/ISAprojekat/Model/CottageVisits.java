package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CottageVisits {

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
    private Cottage cottage;

    public CottageVisits(int numberOfVisits, LocalDate startDate, LocalDate endDate, Cottage cottage) {
        this.numberOfVisits = numberOfVisits;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cottage = cottage;
    }
}
