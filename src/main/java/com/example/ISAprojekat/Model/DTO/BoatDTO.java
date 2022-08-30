package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Boat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoatDTO {

    Long id;
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
    private float srednjaOcena;
    public float latitude;
    public float longitude;
    private String imageEnt1;
    private String imageEnt2;
    private String imageExt1;
    private String imageExt2;


    public BoatDTO(Boat b, float suma) {
        this.id = b.getId();
        this.boatName = b.getBoatName();
        this.boatType = b.getBoatType();
        this.engineNumber = b.getEngineNumber();
        this.enginePower = b.getEnginePower();
        this.maxSpeed = b.getMaxSpeed();
        this.boatAddress = b.getBoatAddress();
        this.boatCapacity = b.getBoatCapacity();
        this.boatRules = b.getBoatRules();
        this.boatDescription = b.getBoatDescription();
        this.additionalEquipment = b.getAdditionalEquipment();
        this.srednjaOcena = suma;
        this.conditions = b.getCancelCondition();
        this.latitude =b.getLatitude();
        this.longitude = b.getLongitude();
        this.imageEnt1 = b.getImageEnt1();
        this.imageEnt2 = b.getImageEnt2();
        this.imageExt1 = b.getImageExt1();
        this.imageExt2 = b.getImageExt2();
    }


    public BoatDTO(Long id, String boatName, String boatType, String engineNumber, String enginePower, int maxSpeed, String boatAddress, int boatCapacity, String boatRules, String boatDescription, String additionalEquipment, String navigationEguipment, String conditions,String imageEnt1,String imageEnt2,String imageExt1,String imageExt2) {
        this.id = id;
        this.boatName = boatName;
        this.boatType = boatType;
        this.engineNumber = engineNumber;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.boatAddress = boatAddress;
        this.boatCapacity = boatCapacity;
        this.boatRules = boatRules;
        this.boatDescription = boatDescription;
        this.additionalEquipment = additionalEquipment;
        this.navigationEguipment = navigationEguipment;
        this.conditions = conditions;
        this.imageEnt1 = imageEnt1;
        this.imageEnt2 = imageEnt2;
        this.imageExt1 = imageExt1;
        this.imageExt2 = imageExt2;
    }


    public BoatDTO(Long id, String boatName, String boatType, String engineNumber, String enginePower, int maxSpeed, String boatAddress, int boatCapacity, String boatRules, String boatDescription, String additionalEquipment, String navigationEguipment, String conditions) {
        this.id = id;
        this.boatName = boatName;
        this.boatType = boatType;
        this.engineNumber = engineNumber;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.boatAddress = boatAddress;
        this.boatCapacity = boatCapacity;
        this.boatRules = boatRules;
        this.boatDescription = boatDescription;
        this.additionalEquipment = additionalEquipment;
        this.navigationEguipment = navigationEguipment;
        this.conditions = conditions;
    }
}
