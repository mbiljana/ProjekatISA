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

    public BoatDTO(Boat b) {
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
    }
}
