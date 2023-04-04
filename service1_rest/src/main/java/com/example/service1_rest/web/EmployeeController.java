package com.example.service1_rest.web;

import com.example.service1_rest.dto.EmployeeDto;
import com.example.service1_rest.exception.ErrorResponse;
import com.example.service1_rest.exception.NoSuchEmployeeException;
import com.example.service1_rest.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public List<EmployeeDto> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable(name="id")UUID id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable(name="id") UUID id ){
       service.delete(id);

    }

    @PostMapping()
    public EmployeeDto save(@RequestBody(required = false) EmployeeDto employeeDto){
        return service.save(employeeDto);
    }

    @PutMapping()
    public EmployeeDto update(@RequestBody(required = false) EmployeeDto employeeDto){
        return service.update(employeeDto);
    }


    @ExceptionHandler(NoSuchEmployeeException.class)
    public ResponseEntity<ErrorResponse> process(NoSuchEmployeeException exception){
        return ResponseEntity.status(404).body(new ErrorResponse(exception.getMessage()));
    }
}
