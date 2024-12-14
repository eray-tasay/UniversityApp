package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "students_to_course_instances")
public class StudentToCourseInstance {
    @EmbeddedId
    public StudentToCourseInstanceKey id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    public Student student;

    @ManyToOne
    @JoinColumn(name = "course_instance_id")
    @MapsId("courseInstanceId")
    public CourseInstance courseInstance;

    public StudentToCourseInstance()
    {
        id = new StudentToCourseInstanceKey();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof StudentToCourseInstance sc && sc.id.equals(id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }
}
