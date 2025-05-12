package com.fiap.sprint_java.dto.supplier;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SupplierResponseDTO {

    private UUID id;
    private String name;
    private String cnpj;
    private String phone;
}
