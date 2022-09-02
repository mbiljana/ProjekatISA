package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private float income;

    public Income(float income) {
        this.income = income;
    }

    public Income(float income, Boat boat) {
        this.income = income;
        this.boat = boat;
    }

    @ManyToOne
    private Boat boat;
}
