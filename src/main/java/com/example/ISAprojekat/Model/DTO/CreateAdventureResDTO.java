package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAdventureResDTO {
    private Long adventureId;
    private Date startDate;
    private int duration;
    private int capacity;
    private String additionalServices;
    private float price;
    private String place;
}
