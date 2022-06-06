package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResIncomeDTO {
    private String resName;
    private Date startDate;
    private float income;
    private int numPeople;

}
