package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.AbstractDatesEntity;
import com.eil.imsbackend.entities.PurchaseLine;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseLineDTO {
    private Integer id;

    private PurchaseDTO purchaseDTO;
    private BigDecimal quantity;

    public static PurchaseLineDTO fromEntity(PurchaseLine purchaseLine) {
        if(purchaseLine == null) {
            return null;
        }

        return PurchaseLineDTO.builder()
                .id(purchaseLine.getId())
                .quantity(purchaseLine.getQuantity())
                .build();
    }

    public static PurchaseLine toEntity(PurchaseLineDTO purchaseDTO) {
        if(purchaseDTO == null) {
            return null;
        }

        PurchaseLine purchaseLine = new PurchaseLine();
        purchaseLine.setId(purchaseDTO.getId());
        purchaseLine.setQuantity(purchaseDTO.getQuantity());
        return purchaseLine;
    }

}
