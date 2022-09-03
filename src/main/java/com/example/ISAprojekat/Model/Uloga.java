package com.example.ISAprojekat.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

//implementiran GrantedAuthority kojim se definišu uloge za autentifikaciju
@Entity
@Table
public class Uloga {

    //private static final long serialVersionUID = 1L;

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="name")
    String name;

    /*@ManyToMany(mappedBy = "uloge")
    List<Korisnik>korisnikList;*/

    @JsonIgnore
    //@Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
