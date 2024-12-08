package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClassroomRepository extends CrudRepository<Classroom, Integer> {
    Optional<Classroom> findClassroomByDescription(String description);
}
