package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IzmenjenKorisnikDTO {
    //izmena uloga
    private Integer id;
    private Integer idTermina;
    private Role role;
    //private String name;


    public IzmenjenKorisnikDTO(Korisnik a) {
        this.id = a.getId();
        //this.name = a.getName();
        this.role = a.getRole();
    }
}
