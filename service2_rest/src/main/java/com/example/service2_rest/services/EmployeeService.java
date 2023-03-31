package com.example.service2_rest.services;

import com.example.service2_rest.dto.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService  {

  Employee getById(UUID id );
  List<Employee> getAll();
  Employee save(Employee employee);
  Employee update (Employee employee);
  void delete(UUID id );

}
