package com.example.ISAprojekat.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class VlasnikBroda extends Korisnik{

    @OneToMany
    private List<Brod> brodovi = new ArrayList<>();

}
