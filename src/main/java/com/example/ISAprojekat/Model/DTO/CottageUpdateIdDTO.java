package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Cottage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageUpdateIdDTO {
    //private Long idKorisnika;
    private Long idCottage;
    private String name;
    private String address;
    private String desc;
    private int rooms;
    private int beds;
    private String services;
    private String rules;


}
