package com.eraytasay.university.service.course.mapper;

import com.eraytasay.university.data.entity.orm.Course;
import com.eraytasay.university.service.course.dto.CourseDTO;
import com.eraytasay.university.service.course.dto.CoursesDTO;
import org.mapstruct.Mapper;

import java.util.stream.StreamSupport;

@Mapper(implementationName = "CourseMapperImpl", componentModel = "spring")
public interface ICourseMapper {
    CourseDTO toCourseDTO(Course course);

    default CoursesDTO toCoursesDTO(Iterable<Course> courses)
    {
        return new CoursesDTO(StreamSupport.stream(courses.spliterator(), false).map(this::toCourseDTO).toList());
    }
}
