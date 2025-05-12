package com.fiap.sprint_java.domain.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class EventRequestDTO {

    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX[VV]")
    private ZonedDateTime date;
    private UUID customerId;
    private UUID carId;
    private UUID employeeId;
}
