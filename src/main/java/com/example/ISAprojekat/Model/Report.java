package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Report implements Serializable {
    @Id
    @SequenceGenerator(name = "reportSeqGen", sequenceName = "reportSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportSeqGen")
    @Column(name="report_id", unique=true, nullable=false)
    private Integer id;
    @Column
    private String content;
/*
    @Column(unique=false, nullable=false)
    private boolean isBadReview;

    @Column(unique=false, nullable=false)
    private boolean notAppeared;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reg_user_id")
    private Korisnik client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private RentingEntity rentingEntity;



    public Report( String content, boolean isBadReview, boolean notAppeared, Korisnik client, RentingEntity rentingEntity) {
        this.content = content;
        this.isBadReview = isBadReview;
        this.notAppeared = notAppeared;
        this.client = client;
        this.rentingEntity = rentingEntity;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBadReview() {
        return isBadReview;
    }

    public void setBadReview(boolean badReview) {
        isBadReview = badReview;
    }

    public boolean isNotAppeared() {
        return notAppeared;
    }

    public void setNotAppeared(boolean notAppeared) {
        this.notAppeared = notAppeared;
    }

    public Korisnik getClient() {
        return client;
    }

    public void setClient(Korisnik client) {
        this.client = client;
    }

    public RentingEntity getRentingEntity() {
        return rentingEntity;
    }

    public void setRentingEntity(RentingEntity rentingEntity) {
        this.rentingEntity = rentingEntity;
    }*/
}
