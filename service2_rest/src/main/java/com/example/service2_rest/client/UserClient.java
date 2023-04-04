package com.example.service2_rest.client;

import com.example.service2_rest.config.FeignConfig;
import com.example.service2_rest.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "userClient",
        url="http://127.0.0.1:8081",
        configuration = FeignConfig.class,
        path = "/employee"

)
public interface UserClient {
    @GetMapping("")
    public List<Employee> getAll();

    @GetMapping("/{id}")
    public Employee getById(@PathVariable(name="id") UUID id);

    @DeleteMapping("/{id}")
    public void delete (@PathVariable(name="id") UUID id );


    @PostMapping
    public Employee save(@RequestBody Employee employeeDto);

    @PutMapping
    public Employee update(@RequestBody Employee employeeDto);
}
