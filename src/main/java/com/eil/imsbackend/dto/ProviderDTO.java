package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Address;
import com.eil.imsbackend.entities.Provider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class ProviderDTO {
    private Integer id;

    private String firstname;
    private String lastname;

    private Address address;

    private String photo;
    private String mail;
    private String phoneNumber;

    @JsonIgnore
    private List<ProviderOrderDTO> providerOrders;

    public ProviderDTO fromEntity(Provider provider) {
        if(provider == null) {
            return null;
        }

        return ProviderDTO.builder()
                .id(provider.getId())
                .address(provider.getAddress())
                .photo(provider.getPhoto())
                .mail(provider.getMail())
                .phoneNumber(provider.getPhoneNumber())
                .build();
    }

    public Provider toEntity(ProviderDTO companyDTO) {
        if(companyDTO == null) {
            return null;
        }

        Provider provider = new Provider();
        provider.setId(companyDTO.getId());
        provider.setAddress(companyDTO.getAddress());
        provider.setPhoto(companyDTO.getPhoto());
        provider.setMail(companyDTO.getMail());
        provider.setPhoneNumber(provider.getPhoneNumber());
        return provider;
    }
}