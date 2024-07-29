package org.huuloc.employeeservice.mapper;

import org.huuloc.employeeservice.dto.EmployeeDto;
import org.huuloc.employeeservice.dto.EmployeeRequest;
import org.huuloc.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeRequest employeeRequest);
}
