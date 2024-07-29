package org.huuloc.employeeservice.service;

import org.huuloc.employeeservice.dto.EmployeeDto;
import org.huuloc.employeeservice.dto.EmployeeRequest;
import org.huuloc.employeeservice.dto.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse findById(Long id);

    EmployeeDto createEmployee(EmployeeRequest employeeRequest);
}
