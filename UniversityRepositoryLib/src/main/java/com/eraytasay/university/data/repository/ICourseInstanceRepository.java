package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceDTO;
import com.eraytasay.university.data.entity.orm.CourseInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseInstanceRepository extends CrudRepository<CourseInstance, Integer> {
    @Query("""
            select new com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceDTO(
            ci.id, co, le, sm, ci.startTime, ci.endTime, ci.dayOfWeek, cl) from CourseInstance ci\s
            join ci.students st join ci.lecturer le join ci.semester sm join ci.course co join ci.classroom cl\s
            where st.id = :studentId""")
    Iterable<CourseInstanceDTO> findCourseInstancesByStudentId(@Param("studentId") int studentId);

    @Query("""
            select new com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceDTO(
            ci.id, co, le, sm, ci.startTime, ci.endTime, ci.dayOfWeek, cl) from CourseInstance ci\s
            join ci.lecturer le join ci.semester sm join ci.course co join ci.classroom cl\s
            where le.id = :lecturerId""")
    Iterable<CourseInstanceDTO> findCourseInstancesByLecturerId(@Param("lecturerId") int lecturerId);
}
