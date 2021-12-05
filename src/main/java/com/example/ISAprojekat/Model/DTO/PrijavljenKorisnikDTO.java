package com.example.ISAprojekat.Model.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrijavljenKorisnikDTO {
    private String username;
    private String password;

    public PrijavljenKorisnikDTO() {
    }

    public PrijavljenKorisnikDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
