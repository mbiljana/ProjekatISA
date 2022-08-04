package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityDTO {
    private Integer id;
    private String name;
    private String description;
    private double averageGrade;
    private String image;
    private Address address;
    private String fishingInstructorName;
    private String entityType;

    public EntityDTO() {}

    public EntityDTO(Integer id, String name, String description, double averageGrade, String image, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageGrade = averageGrade;
        this.image = image;
        this.address = address;
    }
    public EntityDTO(Integer id, String name, String description, double averageGrade, String image, Address address, String fishingInstructorName, String entityType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageGrade = averageGrade;
        this.image = image;
        this.address = address;
        this.entityType = entityType;
    }
}
