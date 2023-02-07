package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.AbstractDatesEntity;
import com.eil.imsbackend.entities.Purchase;
import com.eil.imsbackend.entities.PurchaseLine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDTO {

    private Integer id;

    private String purchaseCode;

    @JsonIgnore
    private List<PurchaseLineDTO> purchaseLines;

    public static PurchaseDTO fromEntity(Purchase purchase) {
        if(purchase == null) {
            return null;
        }

        return PurchaseDTO.builder()
                .id(purchase.getId())
                .purchaseCode(purchase.getPurchaseCode())
                .build();
    }

    public static Purchase toEntity(PurchaseDTO purchaseDTO) {
        if(purchaseDTO == null) {
            return null;
        }

        Purchase purchase = new Purchase();
        purchase.setId(purchaseDTO.getId());
        purchase.setPurchaseCode(purchaseDTO.getPurchaseCode());
        return purchase;
    }
}
