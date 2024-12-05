package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name", length = 100, nullable = false)
    public String firstName;

    @Column(name = "middle_name", length = 100)
    public String middleName;

    @Column(name = "last_name", length = 100, nullable = false)
    public String lastName;

    @Column(length = 200, nullable = false, unique = true)
    public String email;

    @Column(name = "citizen_id", length = 11, nullable = false, unique = true)
    public String citizenId;

    @Column(name = "birth_date")
    public LocalDate birthDate;

    @ManyToMany
    @JoinTable(name = "students_to_departments", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id",
            nullable = false), inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id",
            nullable = false))
    public Set<Department> departments;

    @ManyToMany
    @JoinTable(name = "students_to_course_instances", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_instance_id", referencedColumnName = "course_instance_id"))
    public Set<CourseInstance> courseInstances;

    @OneToMany(mappedBy = "student")
    public Set<StudentToCourseInstance> studentToCourseInstances;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Student s && s.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
