package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(length = 10, nullable = false, unique = true)
    public String code;

    @Column(nullable = false, unique = true)
    public String name;

    @OneToMany(mappedBy = "course")
    public Set<CourseInstance> courseInstances;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Course c && c.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
