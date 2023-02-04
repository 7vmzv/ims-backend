package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.CustomerOrderLine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderLineDTO {
    private Integer id;

    private Article article;
    @JsonIgnore
    private CustomerOrderDTO customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public static CustomerOrderLineDTO fromEntity(CustomerOrderLine customerOrderLine) {
        if(customerOrderLine == null) {
            return null;
        }

        return CustomerOrderLineDTO.builder()
                .id(customerOrderLine.getId())
                .quantity(customerOrderLine.getQuantity())
                .unitPrice(customerOrderLine.getUnitPrice())
                .build();
    }

    public static CustomerOrderLine toEntity(CustomerOrderLineDTO customerOrderLineDTO) {
        if(customerOrderLineDTO == null) {
            return null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDTO.getId());
        customerOrderLine.setArticle(customerOrderLineDTO.getArticle());
        customerOrderLine.setCustomerOrder(CustomerOrderDTO.toEntity(customerOrderLineDTO.getCustomerOrder()));
        customerOrderLine.setQuantity(customerOrderLineDTO.getQuantity());
        customerOrderLine.setUnitPrice(customerOrderLineDTO.getUnitPrice());
        return customerOrderLine;
    }
}
