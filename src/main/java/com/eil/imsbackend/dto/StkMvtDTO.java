package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.AbstractDatesEntity;
import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.StkMvt;
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
public class StkMvtDTO {
    private Integer id;

    private ArticleDTO article;

    private BigDecimal quantity;

    private int mvtType;

    public StkMvtDTO fromEntity(StkMvt stkMvt) {
        if(stkMvt == null) {
            return null;
        }

        return StkMvtDTO.builder()
                .id(stkMvt.getId())
                .quantity(stkMvt.getQuantity())
                .mvtType(stkMvt.getMvtType())
                .build();
    }

    public StkMvt toEntity(StkMvtDTO stkMvtDTO) {
        if(stkMvtDTO == null) {
            return null;
        }

        StkMvt stkMvt = new StkMvt();
        stkMvt.setId(stkMvtDTO.getId());
        stkMvt.setQuantity(stkMvtDTO.getQuantity());
        stkMvt.setMvtType(stkMvt.getMvtType());
        return stkMvt;
    }
}
