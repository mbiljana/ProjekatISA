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
    public float srednjaOcena;
    public float latitude;
    public float longitude;
    public String conditions;
    private String imageEnt1;
    private String imageEnt2;
    private String imageExt1;
    private String imageExt2;

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
        this.imageEnt1 = c.getImageEnt1();
        this.imageEnt2 = c.getImageEnt2();
        this.imageExt1 = c.getImageExt1();
        this.imageExt2 = c.getImageExt2();
    }

    public CottageDTO(Long id, String cottageName, String cottageAddress, String cottageDescription, int numRooms, int numBeds, String cottageAdditionalServices, String cottageRules, String cond) {
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
    public CottageDTO(Long id, String cottageName, String cottageAddress, String cottageDescription, int numRooms, int numBeds, String cottageAdditionalServices, String cottageRules, String cond,String imageEnt1,String imageEnt2,String imageExt1,String imageExt2) {
        this.id = id;
        this.cottageName = cottageName;
        this.cottageAddress = cottageAddress;
        this.cottageDescription = cottageDescription;
        this.numRooms = numRooms;
        this.numBeds = numBeds;
        this.cottageAdditionalServices = cottageAdditionalServices;
        this.cottageRules = cottageRules;
        this.conditions = cond;
        this.imageEnt1 = imageEnt1;
        this.imageEnt2 = imageEnt2;
        this.imageExt1 = imageExt1;
        this.imageExt2 = imageExt2;
    }
}
