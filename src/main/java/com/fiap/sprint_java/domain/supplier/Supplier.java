package com.fiap.sprint_java.domain.supplier;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "supplier")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String cnpj;
    private String phone;
}
