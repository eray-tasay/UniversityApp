package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.StudentDTO;
import com.eraytasay.university.data.entity.orm.Department;
import com.eraytasay.university.data.entity.orm.Student;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(implementationName = "StudentMapperImpl", componentModel = "spring")
public interface IStudentMapper {
    StudentDTO toStudentDTO(Student student);

    default List<String> toDepartmentNames(Set<Department> departments)
    {
        return departments.stream().map(department -> department.name).toList();
    }
}
