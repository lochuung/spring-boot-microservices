package org.huuloc.departmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.huuloc.departmentservice.dto.DepartmentDto;
import org.huuloc.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(
            @PathVariable("code") String code) {
        return ResponseEntity.ok().body(departmentService.findByCode(code));
    }
}
