package com.example.ISAprojekat.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PriceListItem {
    @Id
    @SequenceGenerator(name = "pricelistItemSeqGen", sequenceName = "pricelistItemSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricelistItemSeqGen")
    @Column(name="pricelist_item_id", unique=true, nullable=false)
    private Integer id;

    @Column(unique=false, nullable=false)
    private String service;

    @Column(unique=false, nullable=false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id")
    @JsonIgnoreProperties("pricelistItems")
    private RentingEntity rentingEntity;

    public PriceListItem() {}

    public RentingEntity getRentingEntity() {
        return rentingEntity;
    }

    public void setRentingEntity(RentingEntity rentingEntity) {
        this.rentingEntity = rentingEntity;
    }

    @Override
    public String toString() {
        return "PricelistItem{}";
    }
}
