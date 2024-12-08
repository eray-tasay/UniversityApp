package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceSaveDTO;
import com.eraytasay.university.data.entity.orm.CourseInstance;
import com.eraytasay.university.data.entity.orm.Lecturer;
import com.eraytasay.university.data.entity.orm.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "CourseInstanceSaveDTOMapperImpl", componentModel = "spring")
public interface ICourseInstanceSaveDTOMapper {
    @Mapping(source = "semester.year", target = "year")
    @Mapping(source = "semester.type", target = "type")
    @Mapping(target = "id", ignore = true)
    Semester toSemester(CourseInstanceSaveDTO courseInstanceSaveDTO);

    @Mapping(target = "classroom", ignore = true)
    CourseInstance toCourseInstance(CourseInstanceSaveDTO courseInstanceSaveDTO);

    @Mapping(source = "lecturerId", target = "id")
    Lecturer toLecturer(CourseInstanceSaveDTO courseInstanceSaveDTO);
}
