package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.orm.Student;
import com.eraytasay.university.data.repository.IStudentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentServiceHelper {
    private final IStudentRepository m_studentRepository;

    public StudentServiceHelper(IStudentRepository studentRepository)
    {
        m_studentRepository = studentRepository;
    }

    public Iterable<Student> findAllStudents()
    {
        return m_studentRepository.findAll();
    }

    public Optional<Student> findStudentById(int id)
    {
        return m_studentRepository.findById(id);
    }

    public Optional<Student> findStudentByCitizenId(String citizenId)
    {
        return m_studentRepository.findStudentByCitizenId(citizenId);
    }

    public Iterable<Student> findStudentsByDepartmentId(int departmentId)
    {
        return m_studentRepository.findStudentsByDepartmentId(departmentId);
    }

    public Iterable<Student> findStudentsByDepartmentName(String departmentName)
    {
        return m_studentRepository.findStudentsByDepartmentName(departmentName);
    }

    public Iterable<Student> findStudentsByDepartmentNameAndFacultyName(String departmentName, String facultyName)
    {
        return m_studentRepository.findStudentsByDepartmentNameAndFacultyName(departmentName, facultyName);
    }

    public Iterable<Student> findStudentsByFacultyId(int facultyId)
    {
        return m_studentRepository.findStudentsByFacultyId(facultyId);
    }

    public Iterable<Student> findStudentsByFacultyName(String facultyName)
    {
        return m_studentRepository.findStudentsByFacultyName(facultyName);
    }

    public Iterable<Student> findStudentsByCourseInstanceId(int courseInstanceId)
    {
        return m_studentRepository.findStudentsByCourseInstanceId(courseInstanceId);
    }

    public Iterable<Student> findStudentsByAge(int age)
    {
        return m_studentRepository.findStudentsByAge(age);
    }

    public Iterable<Student> findStudentsByAgeGreaterThan(int age)
    {
        return m_studentRepository.findStudentsByAgeGreaterThan(age);
    }

    public Iterable<Student> findStudentsByAgeLessThan(int age)
    {
        return m_studentRepository.findStudentsByAgeLessThan(age);
    }

    public Iterable<Student> findStudentsByNames(String firstName, String middleName, String lastName)
    {
        return m_studentRepository.findStudentsByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCase(firstName, middleName, lastName);
    }
}
