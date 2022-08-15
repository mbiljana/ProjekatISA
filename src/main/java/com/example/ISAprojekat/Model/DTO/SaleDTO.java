package com.example.ISAprojekat.Model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SaleDTO {
    private Integer id;
    private Date dateTimeFrom;
    private int durationInHours;
    private int maximumPersons;
    private Date expireDateTime;
    private String additionalServices;
    private double price;
    private String entityName;

    public SaleDTO() {
    }

    public SaleDTO(Integer id, Date dateTimeFrom, int durationInHours, int maximumPersons, Date expireDateTime, String additionalServices, double price) {
        this.id = id;
        this.dateTimeFrom = dateTimeFrom;
        this.durationInHours = durationInHours;
        this.maximumPersons = maximumPersons;
        this.expireDateTime = expireDateTime;
        this.additionalServices = additionalServices;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(Date dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public int getMaximumPersons() {
        return maximumPersons;
    }

    public void setMaximumPersons(int maximumPersons) {
        this.maximumPersons = maximumPersons;
    }

    public Date getExpireDateTime() {
        return expireDateTime;
    }

    public void setExpireDateTime(Date expireDateTime) {
        this.expireDateTime = expireDateTime;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
