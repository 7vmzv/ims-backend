package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase extends AbstractDatesEntity{
    private String purchaseCode;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseLine> purchaseLines;

}
