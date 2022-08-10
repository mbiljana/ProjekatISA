package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRequest {
    @Id
    @SequenceGenerator(name = "deleteRequestSeqGen", sequenceName = "deleteRequestSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deleteRequestSeqGen")
    @Column(name = "delete_request_id")
    private Integer id;

    @Column
    private String content;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reg_user_id")
    private Korisnik korisnik;


    public DeleteRequest(String content, Korisnik korisnik) {
        this.content = content;
        this.korisnik = korisnik;
    }
}
