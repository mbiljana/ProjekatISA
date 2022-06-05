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
public class FastResCottDTO {
    private Long cottId;
    private Date startDate;
    private int duration;
    private int capacity;
    private String additionalServices;
}
