package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    public int id;

    @Column(unique = true)
    public String name;

    @OneToMany(mappedBy = "faculty")
    public Set<Department> departments;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Faculty f && f.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}

