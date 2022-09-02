package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoatCDTO {
    private String boatName;
    private String boatType;
    private String engineNumber;
    private String enginePower;
    private int maxSpeed;
    private String boatAddress;
    private int boatCapacity;
    private String boatRules;
    private String boatDescription;
    private String additionalEquipment;
    private String navigationEguipment;
    private String conditions;
    private float latitude;
    private float longitude;
    private String imageEnt1;
    private String imageEnt2;
    private String imageExt1;
    private String imageExt2;
   // private String image;
}
