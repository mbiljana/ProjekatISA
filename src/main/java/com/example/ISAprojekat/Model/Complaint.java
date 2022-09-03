package com.example.ISAprojekat.Model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Complaint {

    @Id
    @SequenceGenerator(name = "complaintSeqGen", sequenceName = "complaintSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaintSeqGen")
    @Column(name="complaint_id", unique=true, nullable=false)
    private Integer id;

    @Column(unique=false, nullable=false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reg_user_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private RentingEntity rentingEntity;

    public Complaint() { }

    public Complaint(String content, Client client, RentingEntity rentingEntity) {
        this.content = content;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RentingEntity getRentingEntity() {
        return rentingEntity;
    }

    public void setRentingEntity(RentingEntity rentingEntity) {
        this.rentingEntity = rentingEntity;
    }
}
