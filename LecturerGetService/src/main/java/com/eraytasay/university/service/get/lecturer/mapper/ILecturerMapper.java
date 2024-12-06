package com.eraytasay.university.service.get.lecturer.mapper;

import com.eraytasay.university.data.entity.orm.Department;
import com.eraytasay.university.data.entity.orm.Lecturer;
import com.eraytasay.university.service.get.lecturer.dto.LecturerDTO;
import com.eraytasay.university.service.get.lecturer.dto.LecturersDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

@Mapper(implementationName = "LecturerMapperSImpl", componentModel = "spring")
public interface ILecturerMapper {
    LecturerDTO toLecturerDTO(Lecturer lecturer);

    default List<String> toDepartmentNames(Set<Department> departments)
    {
        return departments.stream().map(department -> department.name).toList();
    }

    default LecturersDTO toLecturersDTO(Iterable<Lecturer> lecturers)
    {
        return new LecturersDTO(StreamSupport.stream(lecturers.spliterator(), false).map(this::toLecturerDTO).toList());
    }
}
