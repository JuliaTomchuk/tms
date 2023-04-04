package com.example.service2_rest.services.impl;

import com.example.service2_rest.client.UserClient;
import com.example.service2_rest.dto.Employee;
import com.example.service2_rest.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final UserClient userClient;

    @Override
    public Employee getById(UUID id) {
        return userClient.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return userClient.getAll();
    }

    @Override
    public Employee save(Employee employee) {

        return userClient.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return userClient.update(employee);
    }

    @Override
    public void delete(UUID id) {
        userClient.delete(id);
    }
}
