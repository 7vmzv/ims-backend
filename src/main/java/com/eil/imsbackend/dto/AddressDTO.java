package com.eil.imsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class AddressDTO {

    private Integer id;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String country;
}
