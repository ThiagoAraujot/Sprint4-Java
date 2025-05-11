package com.fiap.sprint_java.domain.customer;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "customer")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
}
