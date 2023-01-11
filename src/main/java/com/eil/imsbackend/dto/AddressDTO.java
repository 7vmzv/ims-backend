package com.eil.imsbackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Integer id;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String country;
}
