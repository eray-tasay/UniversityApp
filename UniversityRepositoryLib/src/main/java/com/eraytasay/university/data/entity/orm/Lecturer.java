package com.eraytasay.university.data.entity.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @Column(name = "lecturer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name", length = 100, nullable = false)
    public String firstName;

    @Column(name = "middle_name", length = 100)
    public String middleName;

    @Column(name = "last_name", length = 100, nullable = false)
    public String lastName;

    @Column(name = "citizen_id", length = 11, nullable = false, unique = true)
    public String citizenId;

    @Column(length = 200, nullable = false, unique = true)
    public String email;

    @Column(name = "birth_date")
    public LocalDate birthDate;

    @ManyToMany
    @JoinTable(name = "lecturers_to_departments", joinColumns = @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id",
            nullable = false), inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id",
            nullable = false))
    public Set<Department> departments;

    @OneToMany(mappedBy = "lecturer")
    public Set<CourseInstance> courseInstances;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Lecturer l && l.id == id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
