package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Cottage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageUpdateDTO {
    private String name;
    private String address;
    private String desc;
    private int rooms;
    private int beds;
    private String services;
    private String rules;

    public CottageUpdateDTO(Cottage c) {
        this.name = c.getCottageName();
        this.address = c.getCottageAddress();
        this.desc = c.getCottageDescription();
        this.rooms = c.getNumRooms();
        this.beds = c.getNumBeds();
        this.services = c.getCottageAdditionalServices();
        this.rules = c.getCottageRules();
    }
}
