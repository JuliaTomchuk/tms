package com.example.service2_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private UUID id;
    private Long insuranceNumber;
    private String firstName;
    private String secondName;
    private int salary;
    private JobTitle jobTitle;
}
