package com.fiap.sprint_java.domain.car;

import com.fiap.sprint_java.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "car")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String model;
    private Integer factory_year;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
