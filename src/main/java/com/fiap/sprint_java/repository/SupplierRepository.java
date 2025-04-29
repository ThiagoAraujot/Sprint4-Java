package com.fiap.sprint_java.repository;

import com.fiap.sprint_java.domain.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
