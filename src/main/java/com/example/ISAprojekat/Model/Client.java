package com.example.ISAprojekat.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Column(name="points", unique=false, nullable=true)
    private double points = 0;

    @Column(name="cancellation_number", unique=false, nullable=true)
    private int cancellationNumber = 0;

    @Column(name="client_type", unique=false, nullable=true)
    private ClientType clientType = ClientType.bronze;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "rent_entity", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id", referencedColumnName = "entity_id"))
    private Set<RentingEntity> subscriptions = new HashSet<RentingEntity>();*/


    /*public Client(RegistrationRequest userRequest) {
        super(userRequest);
    }*/

}
