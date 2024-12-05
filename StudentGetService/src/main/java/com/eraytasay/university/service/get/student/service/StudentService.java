package com.eraytasay.university.service.get.student.service;

import com.eraytasay.university.data.dal.StudentServiceHelper;
import com.eraytasay.university.service.get.student.dto.StudentDTO;
import com.eraytasay.university.service.get.student.dto.StudentsDTO;
import com.eraytasay.university.service.get.student.mapper.IStudentMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentServiceHelper m_studentServiceHelper;
    private final IStudentMapper m_studentMapper;

    public StudentService(StudentServiceHelper studentServiceHelper, IStudentMapper studentMapper)
    {
        m_studentServiceHelper = studentServiceHelper;
        m_studentMapper = studentMapper;
    }

    public StudentsDTO findAllStudents()
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findAllStudents());
    }

    public Optional<StudentDTO> findStudentById(int id)
    {
        return m_studentServiceHelper.findStudentById(id).map(m_studentMapper::toStudentDTO);
    }

    public StudentsDTO findStudentByDepartmentId(int departmentId)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByDepartmentId(departmentId));
    }

    public StudentsDTO findStudentByDepartmentName(String departmentName)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByDepartmentName(departmentName));
    }

    public StudentsDTO findStudentByDepartmentNameAndFacultyName(String departmentName, String facultyName)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByDepartmentNameAndFacultyName(departmentName, facultyName));
    }

    public StudentsDTO findStudentsByFacultyId(int facultyId)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByFacultyId(facultyId));
    }

    public StudentsDTO findStudentsByFacultyName(String facultyName)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByFacultyName(facultyName));
    }

    public StudentsDTO findStudentsByCourseInstanceId(int courseInstanceId)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByCourseInstanceId(courseInstanceId));
    }

    public StudentsDTO findStudentsByAge(int age)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByAge(age));
    }

    public StudentsDTO findStudentsByAgeGreaterThan(int age)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByAgeGreaterThan(age));
    }

    public StudentsDTO findStudentsByAgeLessThan(int age)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByAgeLessThan(age));
    }

    public StudentsDTO findStudentsByNames(String firstName, String middleName, String lastName)
    {
        return m_studentMapper.toStudentsDTO(m_studentServiceHelper.findStudentsByNames(firstName, middleName, lastName));
    }
}
