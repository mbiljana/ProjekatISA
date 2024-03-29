package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Cottage;
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
    Integer id;
    public String cottageName;
    public String cottageAddress;
    public String cottageDescription;
    public int numRooms;
    public int numBeds;
    public String cottageAdditionalServices;
    public String cottageRules;
    public float srednjaOcena;
    public float latitude;
    public float longitude;
    public String conditions;

    public CottageDTO(Cottage c, float ocena) {
        this.id = c.getId();
        this.cottageName = c.getCottageName();
        this.cottageAddress = c.getCottageAddress();
        this.cottageDescription = c.getCottageDescription();
        this.numRooms = c.getNumRooms();
        this.numBeds = c.getNumBeds();
        this.cottageAdditionalServices = c.getCottageAdditionalServices();
        this.cottageRules = c.getCottageRules();
        this.srednjaOcena = ocena;
        this.latitude = c.getLatitude();
        this.longitude = c.getLongitude();
        this.conditions = c.getCancelCondition();
    }

    public CottageDTO(Integer id, String cottageName, String cottageAddress, String cottageDescription, int numRooms, int numBeds, String cottageAdditionalServices, String cottageRules, String cond) {
        this.id = id;
        this.cottageName = cottageName;
        this.cottageAddress = cottageAddress;
        this.cottageDescription = cottageDescription;
        this.numRooms = numRooms;
        this.numBeds = numBeds;
        this.cottageAdditionalServices = cottageAdditionalServices;
        this.cottageRules = cottageRules;
        this.conditions = cond;
    }
}
