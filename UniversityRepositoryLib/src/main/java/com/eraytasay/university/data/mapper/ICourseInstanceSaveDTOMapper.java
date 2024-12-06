package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceSaveDTO;
import com.eraytasay.university.data.entity.orm.CourseInstance;
import com.eraytasay.university.data.entity.orm.Lecturer;
import com.eraytasay.university.data.entity.orm.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "CourseInstanceSaveDTOMapperImpl", componentModel = "spring")
public interface ICourseInstanceSaveDTOMapper {
    @Mapping(source = "semesterType", target = "type")
    Semester toSemester(CourseInstanceSaveDTO courseInstanceSaveDTO);

    CourseInstance toCourseInstance(CourseInstanceSaveDTO courseInstanceSaveDTO);

    @Mapping(source = "lecturerId", target = "id")
    Lecturer toLecturer(CourseInstanceSaveDTO courseInstanceSaveDTO);
}
