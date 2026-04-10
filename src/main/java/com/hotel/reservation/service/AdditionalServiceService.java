package com.hotel.reservation.service;

import com.hotel.reservation.dto.ServiceRequestDTO;
import com.hotel.reservation.model.AdditionalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdditionalServiceService {

    public List<AdditionalService> createServices(List<ServiceRequestDTO> servicesDTO) {
        List<AdditionalService> services = new ArrayList<>();
        if (servicesDTO == null) {
            return services;
        }

        for (ServiceRequestDTO dto : servicesDTO) {
            services.add(new AdditionalService(dto.getId(), dto.getServiceType(), dto.getDescription(), dto.getCost()));
        }

        // TODO: Enrich conversion with rules and service catalog.
        return services;
    }

    public double calculateTotalCost(List<AdditionalService> services) {
        if (services == null || services.isEmpty()) {
            return 0.0;
        }
        return services.stream().mapToDouble(AdditionalService::getCost).sum();
    }
}


