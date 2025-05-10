package com.fiap.sprint_java.domain.employee;

import com.fiap.sprint_java.domain.mechanic.Mechanic;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "employee")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue()
    private UUID id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;
}
