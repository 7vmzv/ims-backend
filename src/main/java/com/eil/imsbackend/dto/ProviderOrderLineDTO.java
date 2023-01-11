package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.ProviderOrderLine;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProviderOrderLineDTO {
    private Integer id;

    private Article article;
    private ProviderOrderDTO providerOrder;

    public ProviderOrderLineDTO fromEntity(ProviderOrderLine providerOrderLine) {
        if(providerOrderLine == null) {
            return null;
        }

        return ProviderOrderLineDTO.builder()
                .id(providerOrderLine.getId())
                .build();
    }

    public ProviderOrderLine toEntity(ProviderOrderLineDTO providerOrderLineDTO) {
        if(providerOrderLineDTO == null) {
            return null;
        }

        ProviderOrderLine providerOrderLine = new ProviderOrderLine();
        providerOrderLine.setId(providerOrderLineDTO.getId());
        return providerOrderLine;
    }
}