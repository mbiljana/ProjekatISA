package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageDTO {

    private String cottageName;
    private String cottageAddress;
    private String cottageDescription;
    private int numRooms;
    private int numBeds;
    private String cottageAdditionalServices;
    private String cottageRules;
}
