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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String address;
    private String cnpj;
    private String phone;
    private String email;
}
