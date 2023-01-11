package com.eil.imsbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractDatesEntity{
    private String categoryCode;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
