package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.CustomerOrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderLineDTO {
    private Integer id;

    private Article article;
    private CustomerOrderDTO customerOrder;

    public CustomerOrderLineDTO fromEntity(CustomerOrderLine customerOrderLine) {
        if(customerOrderLine == null) {
            return null;
        }

        return CustomerOrderLineDTO.builder()
                .id(customerOrderLine.getId())
                .build();
    }

    public CustomerOrderLine toEntity(CustomerOrderLineDTO customerOrderLineDTO) {
        if(customerOrderLineDTO == null) {
            return null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDTO.getId());
        return customerOrderLine;
    }
}
