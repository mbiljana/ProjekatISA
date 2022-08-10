package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import com.example.ISAprojekat.Model.Uloga;

@Entity
@Table
@Getter
@Setter
public class RegistrationRequest {
    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String emailAddress;

    @Column
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Uloga uloga;

    @Column
    private String explanation;

    @Column
    private String biography;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public RegistrationRequest(String name, String surname, String emailAddress, String password, Uloga uloga, String explanation, String biography, Address address) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.password = password;
        this.uloga = uloga;
        this.explanation = explanation;
        this.biography = biography;
        this.address = address;
    }

    public RegistrationRequest() { }

    public RegistrationRequest(Integer id, String name, String surname, String emailAddress, String password, String explanation) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.uloga = uloga;
        this.password = password;
        this.explanation = explanation;
    }

}
