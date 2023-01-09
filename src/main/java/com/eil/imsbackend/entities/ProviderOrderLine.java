package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProviderOrderLine extends AbstractDatesEntity{
    @ManyToOne
    private Article article;

    @ManyToOne
    private ProviderOrder providerOrder;

}
