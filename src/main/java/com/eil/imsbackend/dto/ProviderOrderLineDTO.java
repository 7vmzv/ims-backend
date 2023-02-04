package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.ProviderOrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderOrderLineDTO {
    private Integer id;

    private Article article;
    private ProviderOrderDTO providerOrder;

    public static ProviderOrderLineDTO fromEntity(ProviderOrderLine providerOrderLine) {
        if(providerOrderLine == null) {
            return null;
        }

        return ProviderOrderLineDTO.builder()
                .id(providerOrderLine.getId())
                .build();
    }

    public static ProviderOrderLine toEntity(ProviderOrderLineDTO providerOrderLineDTO) {
        if(providerOrderLineDTO == null) {
            return null;
        }

        ProviderOrderLine providerOrderLine = new ProviderOrderLine();
        providerOrderLine.setId(providerOrderLineDTO.getId());
        return providerOrderLine;
    }
}
