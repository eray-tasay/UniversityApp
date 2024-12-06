package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.lecturer.LecturerDTO;
import com.eraytasay.university.data.entity.orm.Department;
import com.eraytasay.university.data.entity.orm.Lecturer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(implementationName = "LecturerMapperImpl", componentModel = "spring")
public interface ILecturerMapper {
    LecturerDTO tolecturerDTO(Lecturer lecturer);

    default List<String> toDepartmentNames(Set<Department> departments)
    {
        return departments.stream().map(department -> department.name).toList();
    }
}
