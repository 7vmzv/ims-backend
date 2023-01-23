package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
