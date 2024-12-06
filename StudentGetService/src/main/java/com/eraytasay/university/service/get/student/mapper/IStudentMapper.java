package com.eraytasay.university.service.get.student.mapper;

import com.eraytasay.university.data.entity.orm .Department;
import com.eraytasay.university.data.entity.orm.Student;
import com.eraytasay.university.service.get.student.dto.StudentDTO;
import com.eraytasay.university.service.get.student.dto.StudentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

@Mapper(implementationName = "StudentMapperSImpl", componentModel = "spring")
public interface IStudentMapper {
    @Mapping(target = "fullName", expression = "java(getFullName(student.firstName, student.middleName, student.lastName))")
    StudentDTO toStudentDTO(Student student);

    default List<String> toDepartmentNames(Set<Department> departments)
    {
        return departments.stream().map(department -> department.name).toList();
    }

    default String getFullName(String firstName, String middleName, String lastName)
    {
        return middleName == null ? "%s %s".formatted(firstName, lastName) : "%s %s %s".formatted(firstName, middleName, lastName);
    }

    default StudentsDTO toStudentsDTO(Iterable<Student> students)
    {
        return new StudentsDTO(StreamSupport.stream(students.spliterator(), false).map(this::toStudentDTO).toList());
    }
}
