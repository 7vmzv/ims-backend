package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.AbstractDatesEntity;
import com.eil.imsbackend.entities.Address;
import com.eil.imsbackend.entities.Customer;
import com.eil.imsbackend.entities.CustomerOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
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
public class CustomerDTO {
    private Integer id;

    private String firstname;
    private String lastname;

    private Address address;

    private String photo;
    private String mail;
    private String phoneNumber;

    @JsonIgnore
    private List<CustomerOrderDTO> customerOrders;

    public static CustomerDTO fromEntity(Customer company) {
        if(company == null) {
            return null;
        }

        return CustomerDTO.builder()
                .id(company.getId())
                .address(company.getAddress())
                .photo(company.getPhoto())
                .mail(company.getMail())
                .phoneNumber(company.getPhoneNumber())
                .build();
    }

    public static Customer toEntity(CustomerDTO companyDTO) {
        if(companyDTO == null) {
            return null;
        }

        Customer company = new Customer();
        company.setId(companyDTO.getId());
        company.setAddress(companyDTO.getAddress());
        company.setPhoto(companyDTO.getPhoto());
        company.setMail(companyDTO.getMail());
        company.setPhoneNumber(company.getPhoneNumber());
        return company;
    }

}
