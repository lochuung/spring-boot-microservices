package org.huuloc.employeeservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private String organizationCode;
}
