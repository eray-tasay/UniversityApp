package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Integer> {
    Optional<Course> findCourseByCode(String code);
    Optional<Course> findCourseByName(String name);
}
