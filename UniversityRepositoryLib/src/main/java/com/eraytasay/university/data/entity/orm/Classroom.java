package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    public int id;

    @Column(nullable = false, unique = true)
    public String description;

    @OneToMany(mappedBy = "classroom")
    public Set<CourseInstance> courseInstances;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Classroom c && c.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
