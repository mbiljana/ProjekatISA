package com.example.ISAprojekat.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class FishingInstructor extends Korisnik implements Serializable {

    //lista usluga
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fa_fid", referencedColumnName = "id")
    //private List<Adventure> adventures = new ArrayList<>();

    @OneToMany(mappedBy = "fishingInstructor",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Adventure> adventures = new HashSet<>();

    /*@Column
    private String availableFrom;

    @Column
    private String availableTo;
*/

}
