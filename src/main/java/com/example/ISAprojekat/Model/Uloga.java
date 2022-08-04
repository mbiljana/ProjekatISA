package com.example.ISAprojekat.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

//implementiran GrantedAuthority kojim se definišu uloge za autentifikaciju
@Entity
@Table(name="ULOGA")
public class Uloga  implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="name")
    String name;

    @JsonIgnore
    @Override
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
