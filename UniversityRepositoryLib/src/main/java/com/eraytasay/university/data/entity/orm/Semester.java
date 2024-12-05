package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "semesters")
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
}
