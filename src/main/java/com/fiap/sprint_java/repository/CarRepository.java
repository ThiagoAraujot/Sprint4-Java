package com.fiap.sprint_java.repository;

import com.fiap.sprint_java.domain.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
