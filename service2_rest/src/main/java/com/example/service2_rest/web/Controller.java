package com.example.service2_rest.web;


import com.example.service2_rest.dto.Employee;
import com.example.service2_rest.exception.ClientException;
import com.example.service2_rest.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service2")
public class Controller {
    private final EmployeeService service;


    @Operation(summary = "Get all employees")
    @ApiResponses(
            value = {
                    @ApiResponse(description = "Return all employees", responseCode = "200",
                            content = @Content(mediaType = "json", array = @ArraySchema(schema = @Schema(name = "employee",
                                    title = "allEmployee", implementation = Employee.class))))
            }
    )
    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }


    @Operation(summary = "Get employee by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ClientException.class)), description = "no such employee"),
                    @ApiResponse(responseCode = "200", description = "return employee by id", content = @Content(mediaType = "json", schema = @Schema(implementation = Employee.class)))
            }
    )
    @GetMapping("/{id}")
    public Employee getById(@PathVariable(name = "id") UUID id) {

        return service.getById(id);
    }


    @Operation(summary = "Delete employee by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "returns nothing"),
                    @ApiResponse(responseCode = "404", description = "no such employee", content = @Content(schema = @Schema(implementation = ClientException.class)))
            }
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        service.delete(id);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "return saved employee", content = @Content(mediaType = "json", schema = @Schema(implementation = Employee.class)))

            }
    )
    @Operation(summary = "Save employee")
    @PostMapping()
    public Employee save(@RequestBody Employee employee) {

        return service.save(employee);
    }


    @Operation(summary = "Update employee")
    @ApiResponses(
            value = {
                    @ApiResponse(description = "return updated employee", responseCode = "200", content = @Content(mediaType = "json", schema = @Schema(implementation = Employee.class))),
                    @ApiResponse(description = "no such employee", responseCode = "404", content = @Content(mediaType = "json", schema = @Schema(implementation = ClientException.class)))
            }
    )
    @PutMapping()
    public Employee update(@RequestBody Employee employee) {

        return service.update(employee);
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ClientException> process(ClientException exception) {
        return ResponseEntity.internalServerError().body(new ClientException(exception.getMessage()));
    }


}
