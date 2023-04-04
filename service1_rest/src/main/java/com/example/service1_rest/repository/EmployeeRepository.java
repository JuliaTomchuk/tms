package com.example.service1_rest.repository;

import com.example.service1_rest.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
}
