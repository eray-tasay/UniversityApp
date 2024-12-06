package com.eraytasay.university.data.mapper;

import com.eraytasay.university.data.entity.dto.lecturer.LecturerSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.lecturer.LecturerSaveWithDepartmentNamesDTO;
import com.eraytasay.university.data.entity.orm.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "LecturerSaveDTOMapperImpl", componentModel = "spring")
public interface ILecturerSaveDTOMapper {
    @Mapping(target = "departments", ignore = true)
    Lecturer toLecturer(LecturerSaveWithDepartmentIdsDTO lecturerSave);

    @Mapping(target = "departments", ignore = true)
    Lecturer toLecturer(LecturerSaveWithDepartmentNamesDTO lecturerSave);
}
