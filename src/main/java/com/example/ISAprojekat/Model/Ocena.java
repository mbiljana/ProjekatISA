package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ocena {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int ocena;
    @ManyToOne
    private Cottage cottage;
    @ManyToOne
    private Boat boat;


}
