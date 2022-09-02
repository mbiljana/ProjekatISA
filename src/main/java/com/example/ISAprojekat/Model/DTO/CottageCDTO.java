package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageCDTO {
    public String cottageName;
    public String cottageAddress;
    public String cottageDescription;
    public int numRooms;
    public int numBeds;
    public String cottageAdditionalServices;
    public String cottageRules;
    public float srednjaOcena;
    public String conditions;
    public float latitude;
    public float longitude;
    private String imageEnt1;
    private String imageEnt2;
    private String imageExt1;
    private String imageExt2;
}
