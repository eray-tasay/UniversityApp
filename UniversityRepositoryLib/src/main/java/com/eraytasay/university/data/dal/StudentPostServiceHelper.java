package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.StudentDTO;
import com.eraytasay.university.data.entity.dto.StudentSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.StudentSaveWithDepartmentNamesDTO;
import com.eraytasay.university.data.mapper.IStudentMapper;
import com.eraytasay.university.data.mapper.IStudentSaveDTOMapper;
import com.eraytasay.university.data.repository.IStudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentPostServiceHelper {
    private final IStudentRepository m_studentRepository;
    private final IStudentSaveDTOMapper m_studentSaveDTOMapper;
    private final IStudentMapper m_studentMapper;
    private final DepartmentUtil m_departmentUtil;

    public StudentPostServiceHelper(IStudentRepository studentRepository, IStudentSaveDTOMapper studentSaveDTOMapper,
                                    IStudentMapper studentMapper, DepartmentUtil departmentUtil)
    {
        m_studentRepository = studentRepository;
        m_studentSaveDTOMapper = studentSaveDTOMapper;
        m_studentMapper = studentMapper;
        m_departmentUtil = departmentUtil;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public StudentDTO saveStudentWithDepartmentIds(StudentSaveWithDepartmentIdsDTO studentSaveWithDepartmentIdsDTO)
    {
        var student = m_studentSaveDTOMapper.toStudent(studentSaveWithDepartmentIdsDTO);

        student.departments = m_departmentUtil.getDepartmentsByIds(studentSaveWithDepartmentIdsDTO.departments);
        m_studentRepository.save(student);

        return m_studentMapper.toStudentDTO(student);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public StudentDTO saveStudentWithDepartmentNames(StudentSaveWithDepartmentNamesDTO studentSaveWithDepartmentNamesDTO)
    {
        var student = m_studentSaveDTOMapper.toStudent(studentSaveWithDepartmentNamesDTO);

        student.departments = m_departmentUtil.getDepartmentsByNames(studentSaveWithDepartmentNamesDTO.departments);
        m_studentRepository.save(student);

        return m_studentMapper.toStudentDTO(student);
    }
}
