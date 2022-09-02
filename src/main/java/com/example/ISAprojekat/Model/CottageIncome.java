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
public class CottageIncome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float income;

    public CottageIncome(float income) {
        this.income = income;
    }

    public CottageIncome(float income, Cottage cottage) {
        this.income = income;
        this.cottage = cottage;
    }

    @ManyToOne
    private Cottage cottage;
}
