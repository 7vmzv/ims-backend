package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<Integer, CustomerOrder> {
}
