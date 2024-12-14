package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.StudentToCourseInstance;
import com.eraytasay.university.data.entity.orm.StudentToCourseInstanceKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentToCourseInstanceRepository extends CrudRepository<StudentToCourseInstance, StudentToCourseInstanceKey> {
}
