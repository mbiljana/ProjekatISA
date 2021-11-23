package com.example.ISAprojekat.DTO;

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

    public BoatDTO(Boat boat) {
        this(boat.getId(), boat.getBoatName(),boat.getBoatType(),boat.getEngineNumber(),boat.getEnginePower(),
                boat.getMaxSpeed(),boat.getBoatAddress(),boat.getBoatCapacity(),boat.getBoatRules(),
                boat.getBoatDescription(),boat.getAdditionalEquipment());
    }
}
