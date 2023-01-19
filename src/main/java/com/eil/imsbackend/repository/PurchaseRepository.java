package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Integer, Purchase> {
}
