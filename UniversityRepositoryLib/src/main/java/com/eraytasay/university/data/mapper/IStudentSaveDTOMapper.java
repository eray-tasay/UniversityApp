package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.student.StudentSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.student.StudentSaveWithDepartmentNamesDTO;
import com.eraytasay.university.data.entity.orm.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "StudentSaveDTOMapperImpl", componentModel = "spring")
public interface IStudentSaveDTOMapper {
    @Mapping(target = "departments", ignore = true)
    Student toStudent(StudentSaveWithDepartmentIdsDTO studentSaveWithDepartmentIdsDTO);

    @Mapping(target = "departments", ignore = true)
    Student toStudent(StudentSaveWithDepartmentNamesDTO studentSaveWithDepartmentNamesDTO);
}
