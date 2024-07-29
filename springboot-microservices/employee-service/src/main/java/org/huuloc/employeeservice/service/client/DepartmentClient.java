package org.huuloc.employeeservice.service.client;

import org.huuloc.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {
    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String code);
}
