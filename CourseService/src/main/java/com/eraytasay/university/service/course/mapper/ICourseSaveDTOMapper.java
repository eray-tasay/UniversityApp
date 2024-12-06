package com.eraytasay.university.service.course.mapper;

import com.eraytasay.university.data.entity.orm.Course;
import com.eraytasay.university.service.course.dto.CourseSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CourseSaveDTOMapperImpl", componentModel = "spring")
public interface ICourseSaveDTOMapper {
    Course toCourse(CourseSaveDTO courseSave);
}
