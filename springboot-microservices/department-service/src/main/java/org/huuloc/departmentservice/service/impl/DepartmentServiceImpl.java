package org.huuloc.departmentservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.huuloc.departmentservice.dto.DepartmentDto;
import org.huuloc.departmentservice.entity.Department;
import org.huuloc.departmentservice.exception.BadRequestException;
import org.huuloc.departmentservice.mapper.DepartmentMapper;
import org.huuloc.departmentservice.repository.DepartmentRepository;
import org.huuloc.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto findByCode(String code) {
        Department department = departmentRepository.findByCode(code)
                .orElseThrow(() -> BadRequestException.message("Department not found!"));
        return DepartmentMapper.INSTANCE.toDto(department);
    }
}
