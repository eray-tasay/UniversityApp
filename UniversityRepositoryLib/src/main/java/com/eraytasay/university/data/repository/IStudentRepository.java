package com.eraytasay.university.data.repository;

import com.eraytasay.university.data.entity.orm.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer> {
    //Here will be changed...
    Optional<Student> findStudentByCitizenId(String citizenId);

    @Query("select s from Student s join s.departments d where d.id = :departmentId")
    Iterable<Student> findStudentsByDepartmentId(@Param("departmentId") int departmentId);

    @Query("select s from Student s join s.departments d where lower(d.name) = lower(:departmentName)")
    Iterable<Student> findStudentsByDepartmentName(@Param("departmentName") String departmentName);

    @Query("select s from Student s join s.departments d join d.faculty f where lower(d.name) = lower(:departmentName) " +
            "and lower(f.name) = lower(:facultyName)")
    Iterable<Student> findStudentsByDepartmentNameAndFacultyName(@Param("departmentName") String departmentName,
                                                                 @Param("facultyName") String facultyName);

    @Query("select s from Student s join s.departments d join d.faculty f where f.id = :facultyId")
    Iterable<Student> findStudentsByFacultyId(@Param("facultyId") int facultyId);

    @Query("select s from Student s join s.departments d join d.faculty f where lower(f.name) = lower(:facultyName)")
    Iterable<Student> findStudentsByFacultyName(@Param("facultyName") String facultyName);

    @Query("select s from Student s join s.courseInstances c where c.id = :courseInstanceId ")
    Iterable<Student> findStudentsByCourseInstanceId(@Param("courseInstanceId") int courseInstanceId);

    @Query("select s from Student s where get_age(s.birthDate) = :age")
    Iterable<Student> findStudentsByAge(@Param("age") int age);

    @Query("select s from Student s where get_age(s.birthDate) > :age")
    Iterable<Student> findStudentsByAgeGreaterThan(@Param("age") int age);

    @Query("select s from Student s where get_age(s.birthDate) < :age")
    Iterable<Student> findStudentsByAgeLessThan(@Param("age") int age);

    Iterable<Student> findStudentsByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String middleName, String lastName);
}
