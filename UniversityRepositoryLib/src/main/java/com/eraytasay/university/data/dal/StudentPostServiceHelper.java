package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.StudentDTO;
import com.eraytasay.university.data.entity.dto.StudentSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.StudentSaveWithDepartmentNamesDTO;
import com.eraytasay.university.data.entity.orm.Department;
import com.eraytasay.university.data.exception.department.NoSuchDepartmentException;
import com.eraytasay.university.data.exception.department.NotUniqueDepartmentException;
import com.eraytasay.university.data.mapper.IStudentMapper;
import com.eraytasay.university.data.mapper.IStudentSaveDTOMapper;
import com.eraytasay.university.data.repository.IDepartmentRepository;
import com.eraytasay.university.data.repository.IStudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class StudentPostServiceHelper {
    private final IStudentRepository m_studentRepository;
    private final IStudentSaveDTOMapper m_studentSaveDTOMapper;
    private final IDepartmentRepository m_departmentRepository;
    private final IStudentMapper m_studentMapper;

    public StudentPostServiceHelper(IStudentRepository studentRepository, IStudentSaveDTOMapper studentSaveDTOMapper, IDepartmentRepository departmentRepository, IStudentMapper studentMapper)
    {
        m_studentRepository = studentRepository;
        m_studentSaveDTOMapper = studentSaveDTOMapper;
        m_departmentRepository = departmentRepository;
        m_studentMapper = studentMapper;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public StudentDTO saveStudentWithDepartmentIds(StudentSaveWithDepartmentIdsDTO studentSaveWithDepartmentIdsDTO)
    {
        var student = m_studentSaveDTOMapper.toStudent(studentSaveWithDepartmentIdsDTO);

        student.departments = getDepartmentsByIds(studentSaveWithDepartmentIdsDTO.departments);
        m_studentRepository.save(student);

        return m_studentMapper.toStudentDTO(student);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public StudentDTO saveStudentWithDepartmentNames(StudentSaveWithDepartmentNamesDTO studentSaveWithDepartmentNamesDTO)
    {
        var student = m_studentSaveDTOMapper.toStudent(studentSaveWithDepartmentNamesDTO);

        student.departments = getDepartmentsByNames(studentSaveWithDepartmentNamesDTO.departments);
        m_studentRepository.save(student);

        return m_studentMapper.toStudentDTO(student);
    }

    private Set<Department> getDepartmentsByIds(List<Integer> departmentIds)
    {
        var departments = new HashSet<Department>();

        departmentIds.forEach(departmentId ->
                m_departmentRepository.findById(departmentId)
                .ifPresentOrElse(departments::add, () -> departmentNotExist(departmentId)));

        return departments;
    }

    private Set<Department> getDepartmentsByNames(List<String> departmentNames)
    {
        var departments = new HashSet<Department>();

        departmentNames.forEach(departmentName -> addDepartment(departmentName, departments));

        return departments;
    }

    private void departmentNotExist(int departmentId)
    {
        throw new NoSuchDepartmentException("There is no department that has id %d".formatted(departmentId));
    }

    private void addDepartment(String departmentName, Set<Department> departmentsRes)
    {
        var departmentsQueried = m_departmentRepository.findByNameIgnoreCase(departmentName);

        if (departmentsQueried.isEmpty())
            throw new NoSuchDepartmentException("There is no %s department".formatted(departmentName));
        if (departmentsQueried.size() > 1)
            throw new NotUniqueDepartmentException("There is more than one department named %s in multiple faculties".formatted(departmentName));

        departmentsRes.add(departmentsQueried.getFirst());
    }
}
