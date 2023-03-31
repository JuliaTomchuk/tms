package com.example.service1_rest.services.impl;

import com.example.service1_rest.domain.EmployeeEntity;
import com.example.service1_rest.dto.EmployeeDto;
import com.example.service1_rest.exception.NoSuchEmployeeException;
import com.example.service1_rest.mapper.EmployeeMapper;
import com.example.service1_rest.repository.EmployeeRepository;
import com.example.service1_rest.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = mapper.convert(employeeDto);
        EmployeeEntity save = repository.save(employeeEntity);
        return mapper.convert(save);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeEntity> all = repository.findAll();
        return mapper.convert(all);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).orElseThrow(NoSuchEmployeeException::new);
        repository.deleteById(id);

    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = repository.findById(employeeDto.getId()).stream()
                .peek(entity -> {
                    entity.setFirstName(employeeDto.getFirstName());
                    entity.setSecondName(employeeDto.getSecondName());
                    entity.setSalary(employeeDto.getSalary());
                    entity.setInsuranceNumber(employeeDto.getInsuranceNumber());
                    entity.setJobTitle(employeeDto.getJobTitle());
                }).findFirst().orElseThrow(NoSuchEmployeeException::new);
        return mapper.convert(employeeEntity);
    }

    @Override
    public EmployeeDto getById(UUID id) {
        EmployeeEntity employeeEntity = repository.findById(id).orElseThrow(NoSuchEmployeeException::new);
        return mapper.convert(employeeEntity);
    }
}
