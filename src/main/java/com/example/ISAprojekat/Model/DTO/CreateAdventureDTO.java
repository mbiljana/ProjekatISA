package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAdventureDTO {
    private String adventureName;
    private String adventureAddress;
    private String promoDescription;
    private String instructorBiography;
    private int adventureCapacity;
    private String adventureRules;
    private String aventureEquipment;
    private String adventureAdditionalServices;
    private Date startDate;
    private int duration;
    private int capacity;
    private String additionalServices;
    private String price;
    private String place;


}
