package com.fiap.sprint_java.domain.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiap.sprint_java.domain.car.Car;
import com.fiap.sprint_java.domain.customer.Customer;
import com.fiap.sprint_java.domain.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class EventResponseDTO {

    private UUID id;
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX[VV]")
    private ZonedDateTime date;
    private Customer customer;
    private Car car;
    private Employee employee;
}
