package org.huuloc.departmentservice.mapper;

import org.huuloc.departmentservice.dto.DepartmentDto;
import org.huuloc.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDto(Department department);
}
