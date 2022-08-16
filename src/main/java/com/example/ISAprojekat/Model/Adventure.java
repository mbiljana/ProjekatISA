package com.example.ISAprojekat.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adventure extends RentingEntity {

    @Column(unique=false, nullable=false)
    private int maxPersons;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "adventure_fishing_equipment", joinColumns = @JoinColumn(name = "entity_id"))
    @Column(name = "fishing_equipment")
    private Set<String> fishingEquipment = new HashSet<String>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "reg_user_id")
    private FishingInstructor fishingInstructor;
    @Id
    private Integer id;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
