package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacultyRepository extends CrudRepository<Faculty, Integer> {
}
