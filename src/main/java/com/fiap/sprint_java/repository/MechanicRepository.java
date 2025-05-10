package com.fiap.sprint_java.repository;

import com.fiap.sprint_java.domain.mechanic.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MechanicRepository extends JpaRepository<Mechanic, UUID> {
}
