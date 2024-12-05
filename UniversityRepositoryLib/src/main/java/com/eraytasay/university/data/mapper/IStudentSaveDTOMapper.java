package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.StudentSaveDTO;
import com.eraytasay.university.data.entity.orm.Student;
import org.mapstruct.Mapper;

@Mapper(implementationName = "StudentSaveDTOMapperImpl", componentModel = "spring")
public interface IStudentSaveDTOMapper {
    Student toStudent(StudentSaveDTO student);
}
