package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Semester;
import com.eraytasay.university.data.entity.orm.SemesterType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISemesterRepository extends CrudRepository<Semester, Integer> {
    Optional<Semester> findSemesterByYearAndType(int year, SemesterType semesterType);
}
