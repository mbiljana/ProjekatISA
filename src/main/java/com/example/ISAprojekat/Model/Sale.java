package com.example.ISAprojekat.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
public class Sale {
    @Id
    @SequenceGenerator(name = "saleSeqGen", sequenceName = "saleSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleSeqGen")
    @Column(name="sale_id", unique=true, nullable=false)
    private Integer id;

    @Column(unique=false, nullable=false)
    private Date dateTimeFrom;

    @Column(unique=false, nullable=false)
    private int durationInHours;

    @Column(unique=false, nullable=false)
    private int maximumPersons;

    @Column(unique=false, nullable=false)
    private Date expireDateTime;

    @Column(unique=false, nullable=true)
    private String additionalServices;

    @Column(unique=false, nullable=false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id")
    @JsonIgnoreProperties("sales")
    private RentingEntity rentingEntity;

    public Sale() {}

    public Sale(Date dateTimeFrom, int durationInHours, int maximumPersons, Date expireDateTime, String additionalServices, double price) {
        this.dateTimeFrom = dateTimeFrom;
        this.durationInHours = durationInHours;
        this.maximumPersons = maximumPersons;
        this.expireDateTime = expireDateTime;
        this.additionalServices = additionalServices;
    }

    public Sale(Date dateTimeFrom, int durationInHours, int maximumPersons, double price) {
        this.dateTimeFrom = dateTimeFrom;
        this.durationInHours = durationInHours;
        this.maximumPersons = maximumPersons;
        this.price = price;
    }


    public Date getSaleEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getDateTimeFrom());
        cal.add(Calendar.HOUR_OF_DAY, this.getDurationInHours());
        return cal.getTime();
    }

    @Override
    public String toString() {
        return "Sale{}";
    }
}
