package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrderLine extends AbstractDatesEntity{

    @ManyToOne
    private Article article;
    @ManyToOne
    private CustomerOrder customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
