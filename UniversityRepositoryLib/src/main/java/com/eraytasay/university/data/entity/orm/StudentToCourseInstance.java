package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "students_to_course_instances")
public class StudentToCourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_to_course_instance_id")
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_instance_id")
    public CourseInstance courseInstance;
}
