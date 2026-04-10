package com.hotel.reservation.dto;

import com.hotel.reservation.enums.ServiceType;

public class ServiceRequestDTO {

    private Long id;
    private ServiceType serviceType;
    private String description;
    private double cost;

    public ServiceRequestDTO() {
    }

    public ServiceRequestDTO(Long id, ServiceType serviceType, String description, double cost) {
        this.id = id;
        this.serviceType = serviceType;
        this.description = description;
        this.cost = cost;
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
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}


