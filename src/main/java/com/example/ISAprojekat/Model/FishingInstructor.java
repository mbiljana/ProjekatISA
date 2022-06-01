package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FishingInstructor extends Korisnik{


    public FishingInstructor(String name, String surname, String emailAddress, String phoneNumber, String city, String state, String homeAddress, Date birthDate, String username, String password, Role role) {
        super( name, surname, emailAddress, phoneNumber, city, state, homeAddress, birthDate, username, password, role);
    }

    //lista avantura
    @OneToMany(mappedBy = "fishingInstructor")
    private List<Adventure> adventures = new ArrayList<>();

    /*@Column
    private String availableFrom;

    @Column
    private String availableTo;
*/

}
