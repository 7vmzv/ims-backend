package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Integer, Customer> {
}
