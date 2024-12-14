package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class StudentToCourseInstanceKey {
    @Column(name = "student_id")
    public int studentId;
    @Column(name = "course_instance_id")
    public int courseInstanceId;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof StudentToCourseInstanceKey sck && sck.studentId == studentId && sck.courseInstanceId == courseInstanceId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentId, courseInstanceId);
    }
}
