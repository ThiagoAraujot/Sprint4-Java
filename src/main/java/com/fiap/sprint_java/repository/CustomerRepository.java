package com.fiap.sprint_java.repository;

import com.fiap.sprint_java.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
