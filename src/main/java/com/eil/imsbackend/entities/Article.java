package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Article extends AbstractDatesEntity{

    private String articleCode;
    private String description;

    private BigDecimal unitPriceHT;
    private BigDecimal tva;
    private BigDecimal unitPriceTTC;

    private String photo;

    @ManyToOne
    private Category category;

}
