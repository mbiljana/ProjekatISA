package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.RentingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportDTO {
    private String content;
    private boolean badReview;
    private boolean notAppeared;
    private String clientEmail;
    private Integer rentingEntityId;

    private String clientFullName;
    private String advertiserFullName;
    private String entityName;

    public ReportDTO(String content) {
    }


    public ReportDTO(String content, boolean badReview, boolean notAppeared, String emailAddress, Integer rentingEntityId, String clientFullName, String entityName) {
        this.content = content;
        this.badReview = badReview;
        this.notAppeared = notAppeared;
        this.clientEmail = emailAddress;
        this.rentingEntityId = rentingEntityId;
        this.clientFullName = clientFullName;
        this.entityName = entityName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBadReview() {
        return badReview;
    }

    public void setBadReview(boolean badReview) {
        this.badReview = badReview;
    }

    public boolean isNotAppeared() {
        return notAppeared;
    }

    public void setNotAppeared(boolean notAppeared) {
        this.notAppeared = notAppeared;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Integer getRentingEntityId() {
        return rentingEntityId;
    }

    public void setRentingEntityId(Integer rentingEntityId) {
        this.rentingEntityId = rentingEntityId;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getAdvertiserFullName() {
        return advertiserFullName;
    }

    public void setAdvertiserFullName(String advertiserFullName) {
        this.advertiserFullName = advertiserFullName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
