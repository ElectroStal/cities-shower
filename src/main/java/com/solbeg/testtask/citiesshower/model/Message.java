package com.solbeg.testtask.citiesshower.model;

public class Message {
    private TechEntity techEntity;
    private BusinessEntity businessEntity;

    public Message() {
    }

    public void setTechEntity(TechEntity techEntity) {
        this.techEntity = techEntity;
    }

    public void setBusinessEntity(BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
    }

    public TechEntity getTechEntity() {
        return techEntity;
    }

    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    public Message(TechEntity techEntity, BusinessEntity businessEntity) {
        this.techEntity = techEntity;
        this.businessEntity = businessEntity;
    }
}
