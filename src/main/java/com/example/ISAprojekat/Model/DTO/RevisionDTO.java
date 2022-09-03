package com.example.ISAprojekat.Model.DTO;

public class RevisionDTO {
    private Integer id;
    private String content;
    private boolean isApproved;
    private Integer mark;
    private Integer reservationId;

    private String clientEmail;
    private String clientFullName;
    private String advertiserFullName;
    private String entityName;
    private String type;

    public RevisionDTO() {}

    public RevisionDTO(Integer id, String content, boolean isApproved, Integer mark, Integer reservationId, String fullName, String name, String s) {
        this.content = content;
        this.isApproved = isApproved;
        this.mark = mark;
        this.reservationId = reservationId;
    }

    public RevisionDTO(Integer id, String content, boolean isApproved, Integer mark, Integer reservationId, String clientEmail,String advertiserFullName, String entityName, String type) {
        this.id = id;
        this.content = content;
        this.isApproved = isApproved;
        this.mark = mark;
        this.reservationId = reservationId;
        this.clientEmail = clientEmail;
        //this.clientFullName = clientFullName;
        this.advertiserFullName = advertiserFullName;
        this.entityName = entityName;
        this.type = type;
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

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
