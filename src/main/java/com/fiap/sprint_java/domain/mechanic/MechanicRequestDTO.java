package com.fiap.sprint_java.domain.mechanic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MechanicRequestDTO {

    private String name;
    private String address;
    private String cnpj;
    private String phone;
    private String email;
}
