package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.CustomerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Integer> {
}
