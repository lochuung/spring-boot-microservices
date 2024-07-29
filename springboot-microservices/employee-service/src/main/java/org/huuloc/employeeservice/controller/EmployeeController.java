package org.huuloc.employeeservice.controller;


import lombok.RequiredArgsConstructor;
import org.huuloc.employeeservice.dto.EmployeeDto;
import org.huuloc.employeeservice.dto.EmployeeRequest;
import org.huuloc.employeeservice.dto.EmployeeResponse;
import org.huuloc.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequest));
    }
}
