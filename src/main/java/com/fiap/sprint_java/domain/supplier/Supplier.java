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
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "cnpj", nullable = false, length = 11)
    private String cnpj;
    @Column(name = "phone")
    private String phone;
}
