package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    public Faculty faculty;

    @ManyToMany(mappedBy = "departments")
    public Set<Student> students;

    @ManyToMany(mappedBy = "departments")
    public Set<Lecturer> lecturers;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Department d && d.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
