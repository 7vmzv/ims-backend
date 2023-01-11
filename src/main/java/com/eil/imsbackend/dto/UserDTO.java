package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDTO {
    private Integer id;

    private String firstname;
    private String lastname;

    private String email;
    private String phoneNumber;

    private Address address;

    private String photo;
    private CompanyDTO company;

    private RoleDTO role;
    
    public UserDTO fromEntity(User user) {
        if(user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .address(user.getAddress())
                .photo(user.getPhoto())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public User toEntity(UserDTO companyDTO) {
        if(companyDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(companyDTO.getId());
        user.setAddress(companyDTO.getAddress());
        user.setPhoto(companyDTO.getPhoto());
        user.setEmail(companyDTO.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());
        return user;
    }
}
