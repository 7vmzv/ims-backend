package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.AbstractDatesEntity;
import com.eil.imsbackend.entities.ProviderOrder;
import com.eil.imsbackend.entities.Provider;
import com.eil.imsbackend.entities.ProviderOrderLine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class ProviderOrderDTO {
    private Integer id;

    private String providerOrderCode;
    private Instant orderDate;
    private Provider provider;

    @JsonIgnore
    private List<ProviderOrderLineDTO> providerOrderLines;

    public ProviderOrderDTO fromEntity(ProviderOrder providerOrder) {
        if (providerOrder == null) {
            return null;
        }

        return ProviderOrderDTO.builder()
                .id(providerOrder.getId())
                .providerOrderCode(providerOrder.getProviderOrderCode())
                .orderDate(providerOrder.getOrderDate())
                .build();
    }

    public ProviderOrder toEntity(ProviderOrderDTO providerOrderDTO) {
        if(providerOrderDTO == null) {
            return null;
        }

        ProviderOrder providerOrder = new ProviderOrder();
        providerOrder.setId(providerOrderDTO.getId());
        providerOrder.setProviderOrderCode(providerOrderDTO.getProviderOrderCode());
        providerOrder.setOrderDate(providerOrderDTO.getOrderDate());
        return providerOrder;
    }
}
