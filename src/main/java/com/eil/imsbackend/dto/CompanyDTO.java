package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Address;
import com.eil.imsbackend.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDTO {
    private Integer id;

    private String name;
    private String description;

    private Address address;

    private String fiscalCode;
    private String photo;

    private String email;
    private String phoneNumber;

    public CompanyDTO fromEntity(Company company) {
        if(company == null) {
            return null;
        }

        return CompanyDTO.builder()
                .id(company.getId())
                .description(company.getDescription())
                .address(company.getAddress())
                .fiscalCode(company.getFiscalCode())
                .photo(company.getPhoto())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .build();
    }

    public Company toEntity(CompanyDTO companyDTO) {
        if(companyDTO == null) {
            return null;
        }

        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setDescription(companyDTO.getDescription());
        company.setAddress(companyDTO.getAddress());
        company.setFiscalCode(companyDTO.getFiscalCode());
        company.setPhoto(companyDTO.getPhoto());
        company.setEmail(companyDTO.getEmail());
        company.setPhoneNumber(company.getPhoneNumber());
        return company;
    }
}
