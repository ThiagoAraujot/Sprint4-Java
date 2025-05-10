package com.fiap.sprint_java.domain.employee;

import com.fiap.sprint_java.domain.mechanic.Mechanic;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmployeeRequestDTO {
    private String name;
    private String phone;
    private String email;
    private String role;
    private String cpf;
    private UUID mechanicId;
}
