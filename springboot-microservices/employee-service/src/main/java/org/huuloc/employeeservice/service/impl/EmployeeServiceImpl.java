package org.huuloc.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.huuloc.departmentservice.exception.BadRequestException;
import org.huuloc.departmentservice.exception.ErrorMessage;
import org.huuloc.employeeservice.dto.DepartmentDto;
import org.huuloc.employeeservice.dto.EmployeeDto;
import org.huuloc.employeeservice.dto.EmployeeRequest;
import org.huuloc.employeeservice.dto.EmployeeResponse;
import org.huuloc.employeeservice.entity.Employee;
import org.huuloc.employeeservice.mapper.EmployeeMapper;
import org.huuloc.employeeservice.repository.EmployeeRepository;
import org.huuloc.employeeservice.service.EmployeeService;
import org.huuloc.employeeservice.service.client.DepartmentClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    @Override
    public EmployeeResponse findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> BadRequestException.message("The employee is not found"));
        DepartmentDto departmentDto;
        try {
            departmentDto = departmentClient
                    .getDepartmentByCode(employee.getDepartmentCode());
        } catch (Exception e) {
            throw BadRequestException.message("The department is not found!");
        }
        return EmployeeResponse.builder()
                .department(departmentDto)
                .employee(EmployeeMapper.INSTANCE.toDto(employee))
                .build();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeRequest employeeRequest) {
        DepartmentDto departmentDto;
        try {
            departmentDto = departmentClient
                    .getDepartmentByCode(employeeRequest.getDepartmentCode());
        } catch (Exception e) {
            throw BadRequestException.message("The department is not found!");
        }
        if (departmentDto == null) {
            throw BadRequestException.message("The department is not found!");
        }
        Employee employee = employeeRepository.save(EmployeeMapper.INSTANCE
                .toEntity(employeeRequest));
        return EmployeeMapper.INSTANCE.toDto(employee);
    }
}
