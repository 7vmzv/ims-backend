package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.ProviderOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderOrderLineRepository extends JpaRepository<ProviderOrderLine, Integer> {
}
