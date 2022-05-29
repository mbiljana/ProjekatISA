package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Adventure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdventureDTO {
    private Long id;
    private String adventureName;
    private String adventureAddress;
    private String promoDescription;
    private String instructorBiography;
    private int adventureCapacity;
    private String adventureRules;
    private String aventureEquipment;
    private String adventureAdditionalServices;


    public AdventureDTO(Adventure a) {
        this.id = a.getId();
        this.adventureName = a.getAdventureName();
        this.adventureAddress = a.getAdventureAddress();
        this.promoDescription = a.getPromoDescription();
        this.instructorBiography = a.getInstructorBiography();
        this.adventureCapacity = a.getAdventureCapacity();
        this.adventureRules = a.getAdventureRules();
        this.aventureEquipment = a.getAventureEquipment();
        this.adventureAdditionalServices = a.getAdventureAdditionalServices();
    }



    public AdventureDTO(Long id, String adventureName, String adventureRules, String promoDescription, int adventureCapacity, String adventureAddress, String adventureAdditionalServices, String aventureEquipment, String instructorBiography) {
    }


    public AdventureDTO(String adventureName, String adventureRules, String promoDescription, int adventureCapacity, String adventureAddress, String adventureAdditionalServices, String aventureEquipment, String instructorBiography) {
    }
}
