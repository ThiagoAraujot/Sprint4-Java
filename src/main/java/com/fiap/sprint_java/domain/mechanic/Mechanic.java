package com.fiap.sprint_java.domain.mechanic;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "mechanic")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mechanic {

    @Id
    @GeneratedValue()
    private UUID id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 14)
    private String cnpj;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
}
