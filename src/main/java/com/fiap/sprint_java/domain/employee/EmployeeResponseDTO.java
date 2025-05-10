package com.fiap.sprint_java.domain.employee;

import com.fiap.sprint_java.domain.mechanic.Mechanic;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmployeeResponseDTO {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String role;
    private String cpf;
    private Mechanic mechanic;
}
