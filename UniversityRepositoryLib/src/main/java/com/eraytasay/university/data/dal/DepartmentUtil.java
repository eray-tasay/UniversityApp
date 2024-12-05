package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.orm.Department;
import com.eraytasay.university.data.exception.department.NoSuchDepartmentException;
import com.eraytasay.university.data.exception.department.NotUniqueDepartmentException;
import com.eraytasay.university.data.repository.IDepartmentRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
class DepartmentUtil {
    private final IDepartmentRepository m_departmentRepository;

    public DepartmentUtil(IDepartmentRepository departmentRepository)
    {
        m_departmentRepository = departmentRepository;
    }

    public Set<Department> getDepartmentsByIds(List<Integer> departmentIds)
    {
        var departments = new HashSet<Department>();

        departmentIds.forEach(departmentId ->
                m_departmentRepository.findById(departmentId)
                        .ifPresentOrElse(departments::add, () -> departmentNotExist(departmentId)));

        return departments;
    }

    public Set<Department> getDepartmentsByNames(List<String> departmentNames)
    {
        var departments = new HashSet<Department>();

        departmentNames.forEach(departmentName -> addDepartment(departmentName, departments));

        return departments;
    }

    public void departmentNotExist(int departmentId)
    {
        throw new NoSuchDepartmentException("There is no department that has id %d".formatted(departmentId));
    }

    public void addDepartment(String departmentName, Set<Department> departmentsRes)
    {
        var departmentsQueried = m_departmentRepository.findByNameIgnoreCase(departmentName);

        if (departmentsQueried.isEmpty())
            throw new NoSuchDepartmentException("There is no %s department".formatted(departmentName));
        if (departmentsQueried.size() > 1)
            throw new NotUniqueDepartmentException("There is more than one department named %s in multiple faculties".formatted(departmentName));

        departmentsRes.add(departmentsQueried.getFirst());
    }
}
