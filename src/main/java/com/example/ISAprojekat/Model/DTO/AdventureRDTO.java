package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdventureRDTO {
    private String adventureName;
    private String adventureAddress;
    private String promoDescription;
    private String instructorBiography;
    private int adventureCapacity;
    private String adventureRules;
    private String aventureEquipment;
    private String adventureAdditionalServices;
}
