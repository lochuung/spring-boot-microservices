package org.huuloc.departmentservice.service;

import org.huuloc.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto findByCode(String code);
}
