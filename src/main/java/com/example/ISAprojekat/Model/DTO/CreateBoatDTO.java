package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Boat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoatDTO {

    //Long id;
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
    private Date startDate;
    private int duration;
    private int capacity;
    private String additionalServices;
    private String price;

    public CreateBoatDTO(Boat b) {
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
