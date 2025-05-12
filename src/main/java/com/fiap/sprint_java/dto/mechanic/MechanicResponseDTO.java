package com.fiap.sprint_java.dto.mechanic;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MechanicResponseDTO {

    private UUID id;
    private String name;
    private String address;
    private String cnpj;
    private String phone;
    private String email;
}
