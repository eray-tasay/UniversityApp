package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Entity
@Table(name = "semesters", uniqueConstraints = @UniqueConstraint(columnNames = {"year", "type"}))
@Check(constraints = "year > 1900")
public class Semester {
    @Id
    @Column(name = "semester_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int year;

    @Enumerated(EnumType.STRING)
    public SemesterType type;

    @OneToMany(mappedBy = "semester")
    public Set<CourseInstance> courseInstances;

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Semester s && s.id == id;
    }
}
