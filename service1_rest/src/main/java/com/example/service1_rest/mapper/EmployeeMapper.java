package com.example.service1_rest.mapper;

import com.example.service1_rest.domain.EmployeeEntity;
import com.example.service1_rest.dto.EmployeeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface EmployeeMapper {

     EmployeeDto convert(EmployeeEntity entity);
     EmployeeEntity convert(EmployeeDto dto);
     List <EmployeeDto> convert(List<EmployeeEntity> employeeEntityList);

}
