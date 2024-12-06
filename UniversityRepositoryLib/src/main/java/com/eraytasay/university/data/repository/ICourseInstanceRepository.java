package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.CourseInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseInstanceRepository extends CrudRepository<CourseInstance, Integer> {
    @Query("select cs from CourseInstance cs join cs.students s where s.id = :studentId")
    Iterable<CourseInstance> findCourseInstancesByStudentId(@Param("studentId") int studentId);

    @Query("select cs from CourseInstance cs join cs.lecturer l where l.id = :lecturerId")
    Iterable<CourseInstance> findCourseInstancesByLecturerId(@Param("lecturerId") int lecturerId);
}
