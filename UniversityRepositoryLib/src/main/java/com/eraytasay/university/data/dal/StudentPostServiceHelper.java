package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.StudentSaveDTO;
import com.eraytasay.university.data.entity.orm.Student;
import com.eraytasay.university.data.mapper.IStudentSaveDTOMapper;
import com.eraytasay.university.data.repository.IStudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentPostServiceHelper {
    private final IStudentRepository m_studentRepository;
    private final IStudentSaveDTOMapper m_studentSaveDTOMapper;

    public StudentPostServiceHelper(IStudentRepository studentRepository, IStudentSaveDTOMapper studentSaveDTOMapper)
    {
        m_studentRepository = studentRepository;
        m_studentSaveDTOMapper = studentSaveDTOMapper;
    }

    public Student saveStudent(StudentSaveDTO studentSaveDTO)
    {
        return m_studentRepository.save(m_studentSaveDTOMapper.toStudent(studentSaveDTO));
    }
}
