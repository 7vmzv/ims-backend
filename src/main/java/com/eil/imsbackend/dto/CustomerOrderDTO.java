package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.CustomerOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderDTO {

    private Integer id;

    private String customerOrderCode;

    private Instant orderDate;
    private CustomerDTO customer;

    @JsonIgnore
    private List<CustomerOrderLineDTO> customerOrderLines;

    public CustomerOrderDTO fromEntity(CustomerOrder customerOrder) {
        if (customerOrder == null) {
            return null;
        }

        return CustomerOrderDTO.builder()
                .id(customerOrder.getId())
                .customerOrderCode(customerOrder.getCustomerOrderCode())
                .orderDate(customerOrder.getOrderDate())
                .build();
    }

    public CustomerOrder toEntity(CustomerOrderDTO customerOrderDTO) {
        if(customerOrderDTO == null) {
            return null;
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(customerOrderDTO.getId());
        customerOrder.setCustomerOrderCode(customerOrderDTO.getCustomerOrderCode());
        customerOrder.setOrderDate(customerOrderDTO.getOrderDate());
        return customerOrder;
    }
}
