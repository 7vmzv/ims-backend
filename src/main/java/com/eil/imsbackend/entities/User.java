package com.eil.imsbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User extends AbstractDatesEntity{
    private String firstname;
    private String lastname;

    private String email;
    private String phoneNumber;
    @Embedded
    private Address address;

    private String photo;
    @ManyToOne
    private Company company;

    @ManyToOne
    private Role role;
}
