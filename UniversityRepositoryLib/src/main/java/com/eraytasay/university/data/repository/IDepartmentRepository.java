package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Department;
import org.springframework.data.repository.CrudRepository;

public interface IDepartmentRepository extends CrudRepository<Department, Integer> {
}
