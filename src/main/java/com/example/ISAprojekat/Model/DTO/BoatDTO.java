package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Boat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoatDTO {

    Integer id;
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
    }

    public BoatDTO(Integer id, String boatName, String boatType, String engineNumber, String enginePower, int maxSpeed, String boatAddress, int boatCapacity, String boatRules, String boatDescription, String additionalEquipment, String navigationEguipment, String conditions) {
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
