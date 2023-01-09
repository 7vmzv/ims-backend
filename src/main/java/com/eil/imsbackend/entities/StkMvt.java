package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StkMvt extends AbstractDatesEntity{
    @ManyToOne
    private Article article;

    private BigDecimal quantity;

    private int mvtType;
}
