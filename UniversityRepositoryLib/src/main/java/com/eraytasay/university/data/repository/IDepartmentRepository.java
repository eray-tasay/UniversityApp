package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findByNameIgnoreCase(String name);
}
