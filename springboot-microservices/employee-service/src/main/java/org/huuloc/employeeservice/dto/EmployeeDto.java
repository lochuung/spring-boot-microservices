package org.huuloc.employeeservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
