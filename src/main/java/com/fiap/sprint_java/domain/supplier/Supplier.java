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
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 14)
    private String cnpj;
    @Column(nullable = false)
    private String phone;
}
