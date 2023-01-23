package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
