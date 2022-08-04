package com.example.ISAprojekat.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//izdvojena klasa sa kordinatama
@Entity
@Getter
@Setter
public class Address {
    @Id
    @SequenceGenerator(name = "addressSeqGen", sequenceName = "addressSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSeqGen")
    @Column(name="address_id", unique=true, nullable=false)
    private Integer id;

    @Column(name="street_name", unique=false, nullable=false)
    private String streetName;

    @Column(name="street_number", unique=false, nullable=false)
    private String streetNumber;

    @Column(name="postal_code", unique=false, nullable=false)
    private String postalCode;

    @Column(name="city", unique=false, nullable=false)
    private String city;

    @Column(name="country", unique=false, nullable=false)
    private String country;

    private double longitude;
    private double latitude;

    public Address() { }

    public Address(String streetName, String streetNumber, String postalCode, String city, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Address(Integer id, String streetName, String streetNumber, String postalCode, String city, String country) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }


}
