package com.example.service1_rest.services;

import com.example.service1_rest.dto.EmployeeDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeDto save (EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
    void delete(UUID id);
    EmployeeDto update(EmployeeDto employeeDto);
    EmployeeDto getById(UUID id);
}
