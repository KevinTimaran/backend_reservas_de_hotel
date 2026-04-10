package com.hotel.reservation.model;

import com.hotel.reservation.enums.ServiceType;

public class AdditionalService {

    private Long id;
    private ServiceType serviceType;
    private String description;
    private double costo;

    public AdditionalService() {
    }

    public AdditionalService(Long id, ServiceType serviceType, String description, double cost) {
        this.id = id;
        this.serviceType = serviceType;
        this.description = description;
        this.costo = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return costo;
    }

    public void setCost(double cost) {
        this.costo = cost;
    }
}


