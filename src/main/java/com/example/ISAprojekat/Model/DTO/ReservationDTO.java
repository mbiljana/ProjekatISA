package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.CottageReservation;
import com.example.ISAprojekat.Model.RegKorisnik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ReservationDTO {

    private Integer id;
    private Date dateTime;
    private int durationInHours;
    private int maxPersons;
    private Set<String> additionalServices = new HashSet<String>();
    private double price;
    private Boolean isCanceled = false;
    private Integer entityId;
    private String entityName;
    private Integer entityVersion;
    private String clientName;
    private String clientEmail;

    public ReservationDTO() {}

    public ReservationDTO(Date dateTime, int durationInHours, int maxPersons, double price, Boolean isCanceled, Integer entityId, String entityName) {
        this.dateTime = dateTime;
        this.durationInHours = durationInHours;
        this.maxPersons = maxPersons;
        this.price = price;
        this.isCanceled = isCanceled;
        this.entityId = entityId;
        this.entityName = entityName;
    }

    public ReservationDTO(Integer id, Date dateTime, int durationInHours, int maxPersons, double price, Boolean isCanceled, Integer entityId, String entityName) {
        this.id = id;
        this.dateTime = dateTime;
        this.durationInHours = durationInHours;
        this.maxPersons = maxPersons;
        this.price = price;
        this.isCanceled = isCanceled;
        this.entityId = entityId;
        this.entityName = entityName;
    }

    public ReservationDTO(Integer id, Date dateTime, int durationInHours, int maxPersons, double price, Boolean isCanceled, Integer entityId, String entityName, String clientName, String clientEmail) {
        this.id = id;
        this.dateTime = dateTime;
        this.durationInHours = durationInHours;
        this.maxPersons = maxPersons;
        this.price = price;
        this.isCanceled = isCanceled;
        this.entityId = entityId;
        this.entityName = entityName;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public ReservationDTO(Date dateTime, int durationInHours, int maxPersons, Set<String> additionalServices, double price, Boolean isCanceled, Integer entityId, String entityName) {
        this.dateTime = dateTime;
        this.durationInHours = durationInHours;
        this.maxPersons = maxPersons;
        this.additionalServices = additionalServices;
        this.price = price;
        this.isCanceled = isCanceled;
        this.entityId = entityId;
        this.entityName = entityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public int getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(int maxPersons) {
        this.maxPersons = maxPersons;
    }

    public Set<String> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(Set<String> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getEntityVersion() { return entityVersion; }

    public void setEntityVersion(Integer entityVersion) {  this.entityVersion = entityVersion;  }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }



    /*private String resName;
    private Date startDate;
    private Date endDate;
    private Integer offerId;
    private Integer korisnikId;
    private int duration;

    public ReservationDTO(BoatReservation b) {
        this.resName = b.getResName();
        this.startDate = b.getStartDate();
        this.endDate = b.getEndDate();
        this.offerId = b.getBoat().getId();
        this.korisnikId = b.getRegKorisnik().getId();
        this.duration = b.getDuration();
    }
    public ReservationDTO(CottageReservation b) {
        this.resName = b.getResName();
        this.startDate = b.getStartDate();
        this.endDate = b.getEndDate();
        this.offerId = b.getCottage().getId();
        this.korisnikId = b.getRegKorisnik().getId();
        this.duration = b.getDuration();
    }*/


}
