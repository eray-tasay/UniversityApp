package com.eraytasay.university.service.get.courseinstance.mapper;

import com.eraytasay.university.data.entity.orm.*;
import com.eraytasay.university.service.get.courseinstance.dto.CourseDTO;
import com.eraytasay.university.service.get.courseinstance.dto.CourseInstanceDTO;
import com.eraytasay.university.service.get.courseinstance.dto.CourseInstancesDTO;
import com.eraytasay.university.service.get.courseinstance.dto.SemesterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.StreamSupport;

@Mapper(implementationName = "CourseInstanceDTOMapperImpl", componentModel = "spring")
public interface ICourseInstanceDTOMapper {
    @Mapping(source = "lecturer", target = "lecturerFullName")
    CourseInstanceDTO toCourseInstanceDTO(com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceDTO courseInstanceDTO);

    default CourseInstancesDTO toCourseInstancesDTO(Iterable<com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceDTO> courseInstances)
    {
        return new CourseInstancesDTO(StreamSupport.stream(courseInstances.spliterator(), false).map(this::toCourseInstanceDTO).toList());
    }

    default CourseDTO toCourseDTO(Course course)
    {
        var res = new CourseDTO();

        res.code = course.code;
        res.name = course.name;
        return res;
    }

    default SemesterDTO toSemesterDTO(Semester semester)
    {
        var semesterDTO = new SemesterDTO();

        semesterDTO.type = semester.type;
        semesterDTO.year = semester.year;
        return semesterDTO;
    }

    default String getFullName(Lecturer lecturer)
    {
        var firstName = lecturer.firstName;
        var middleName = lecturer.middleName;
        var lastName = lecturer.lastName;

        return middleName == null ? "%s %s".formatted(firstName, lastName) : "%s %s %s".formatted(firstName, middleName, lastName);
    }

    default String getDescription(Classroom classroom)
    {
        return classroom.description;
    }
}
