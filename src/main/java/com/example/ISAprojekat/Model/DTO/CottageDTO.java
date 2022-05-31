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
    Long id;
    public String cottageName;
    public String cottageAddress;
    public String cottageDescription;
    public int numRooms;
    public int numBeds;
    public String cottageAdditionalServices;
    public String cottageRules;

    public CottageDTO(Cottage c) {
        this.id = c.getId();
        this.cottageName = c.getCottageName();
        this.cottageAddress = c.getCottageAddress();
        this.cottageDescription = c.getCottageDescription();
        this.numRooms = c.getNumRooms();
        this.numBeds = c.getNumBeds();
        this.cottageAdditionalServices = c.getCottageAdditionalServices();
        this.cottageRules = c.getCottageRules();
    }
}
