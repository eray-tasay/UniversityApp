package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.LecturerDTO;
import com.eraytasay.university.data.entity.dto.LecturerSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.LecturerSaveWithDepartmentNamesDTO;
import com.eraytasay.university.data.mapper.ILecturerMapper;
import com.eraytasay.university.data.mapper.ILecturerSaveDTOMapper;
import com.eraytasay.university.data.repository.ILecturerRepository;
import org.springframework.stereotype.Component;

@Component
public class LecturerPostServiceHelper {
    private final ILecturerRepository m_lecturerRepository;
    private final ILecturerSaveDTOMapper m_lecturerSaveDTOMapper;
    private final ILecturerMapper m_lecturerMapper;
    private final DepartmentUtil m_departmentUtil;

    public LecturerPostServiceHelper(ILecturerRepository lecturerRepository, ILecturerSaveDTOMapper lecturerSaveDTOMapper, ILecturerMapper lecturerMapper, DepartmentUtil departmentUtil)
    {
        m_lecturerRepository = lecturerRepository;
        m_lecturerSaveDTOMapper = lecturerSaveDTOMapper;
        m_lecturerMapper = lecturerMapper;
        m_departmentUtil = departmentUtil;
    }

    public LecturerDTO saveLecturerWithDepartmentNames(LecturerSaveWithDepartmentNamesDTO lecturerSave)
    {
        var lecturer = m_lecturerSaveDTOMapper.toLecturer(lecturerSave);

        lecturer.departments = m_departmentUtil.getDepartmentsByNames(lecturerSave.departments);
        m_lecturerRepository.save(lecturer);

        return m_lecturerMapper.tolecturerDTO(lecturer);
    }

    public LecturerDTO saveLecturerWithDepartmentIds(LecturerSaveWithDepartmentIdsDTO lecturerSave)
    {
        var lecturer =  m_lecturerSaveDTOMapper.toLecturer(lecturerSave);

        lecturer.departments = m_departmentUtil.getDepartmentsByIds(lecturerSave.departments);
        m_lecturerRepository.save(lecturer);

        return m_lecturerMapper.tolecturerDTO(lecturer);
    }
}
