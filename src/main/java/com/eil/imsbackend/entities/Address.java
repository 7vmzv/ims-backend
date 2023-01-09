package com.eil.imsbackend.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address{

    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String country;

}
