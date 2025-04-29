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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String role;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;
}
