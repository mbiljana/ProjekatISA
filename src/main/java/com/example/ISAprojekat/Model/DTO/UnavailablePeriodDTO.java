package com.example.ISAprojekat.Model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UnavailablePeriodDTO {
    private Integer id;
    private Date fromDateTime;
    private Date toDateTime;
    private String message;
    private Integer entityId;
    private String entityName;

    public UnavailablePeriodDTO() {}

    public UnavailablePeriodDTO(Integer id, Date fromDateTime, Date toDateTime, String message) {
        this.id = id;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.message = message;
    }

    public UnavailablePeriodDTO(Date fromDateTime, Date toDateTime, String name){
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.entityName = name;
    }

    public UnavailablePeriodDTO(Date fromDateTime, Date toDateTime, Integer id){
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.entityId = id;
    }
}
