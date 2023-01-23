package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.AbstractDatesEntity;
import com.eil.imsbackend.entities.Role;
import com.eil.imsbackend.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class RoleDTO {
    private Integer id;

    private String role;
    
    @JsonIgnore
    private List<UserDTO> users;

    public RoleDTO fromEntity(Role role) {
        if(role == null) {
            return null;
        }

        return RoleDTO.builder()
                .id(role.getId())
                .role(role.getRole())
                .build();
    }

    public Role toEntity(RoleDTO roleDTO) {
        if(roleDTO == null) {
            return null;
        }

        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setRole(roleDTO.getRole());
        return role;
    }
}
