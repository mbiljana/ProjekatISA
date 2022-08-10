package com.example.ISAprojekat.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Admin extends Korisnik {

    private boolean initialPasswordChanged;
    public Admin() {
    }

    public Admin(Korisnik user, boolean initialPasswordChanged) {
        super(user);
        this.initialPasswordChanged = initialPasswordChanged;
    }

    public boolean isInitialPasswordChanged() {
        return initialPasswordChanged;
    }

    public void setInitialPasswordChanged(boolean initialPasswordChanged) {
        this.initialPasswordChanged = initialPasswordChanged;
    }

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<ZahtevZaReg> zahtevi = new ArrayList<>();

    /*@OneToMany(mappedBy = "admin")
    public List<Report> reports = new ArrayList<>();*/
}
