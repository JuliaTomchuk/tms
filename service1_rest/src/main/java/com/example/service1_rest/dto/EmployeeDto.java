package com.example.service1_rest.dto;

import com.example.service1_rest.domain.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private UUID id;
    private Long insuranceNumber;
    private String firstName;
    private String secondName;
    private int salary;
    private JobTitle jobTitle;
}
