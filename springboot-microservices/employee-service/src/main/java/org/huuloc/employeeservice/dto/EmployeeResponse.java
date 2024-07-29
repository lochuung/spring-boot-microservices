package org.huuloc.employeeservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class EmployeeResponse {
    private EmployeeDto employee;
    private DepartmentDto department;
}
