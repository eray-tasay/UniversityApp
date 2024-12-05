package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "course_instances")
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_instance_id")
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    public Lecturer lecturer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id")
    public Semester semester;

    @Column(name = "start_time", nullable = false)
    public LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    public LocalTime endTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "day_of_week")
    public DayOfWeek dayOfWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    public Classroom classroom;

    @ManyToMany(mappedBy = "courseInstances")
    public Set<Student> students;

    @OneToMany(mappedBy = "courseInstance")
    public Set<StudentToCourseInstance> studentToCourseInstances;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof CourseInstance c && c.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
