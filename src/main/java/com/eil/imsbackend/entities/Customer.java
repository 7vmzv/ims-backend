package com.eil.imsbackend.entities;

import jakarta.persistence.Embedded;
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
public class Customer extends AbstractDatesEntity{
    private String firstname;
    private String lastname;

    @Embedded
    private Address address;

    private String photo;
    private String mail;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;
}
