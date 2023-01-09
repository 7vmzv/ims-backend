package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends AbstractDatesEntity{
    private String name;
    private String description;

    private Address address;

    private String fiscalCode;
    private String photo;

    private String email;
    private String phoneNumber;
}
