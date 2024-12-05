package com.eraytasay.university.service.get.student.mapper;

import com.eraytasay.university.data.entity.orm.Department;
import com.eraytasay.university.service.get.student.dto.DepartmentDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "DepartmentMapperImpl", componentModel = "spring")
public interface IDepartmentMapper {
    DepartmentDTO toDepartmentDTO(Department department);
}
