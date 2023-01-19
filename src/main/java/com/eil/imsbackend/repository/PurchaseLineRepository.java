package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.PurchaseLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseLineRepository extends JpaRepository<Integer, PurchaseLine> {
}
