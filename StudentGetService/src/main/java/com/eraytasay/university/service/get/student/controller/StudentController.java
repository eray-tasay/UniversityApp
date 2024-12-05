package com.eraytasay.university.service.get.student.controller;

import com.eraytasay.university.service.get.student.dto.StudentDTO;
import com.eraytasay.university.service.get.student.dto.StudentsDTO;
import com.eraytasay.university.service.get.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/get/students")
@RestController
public class StudentController {
    private final StudentService m_studentService;

    public StudentController(StudentService studentService)
    {
        m_studentService = studentService;
    }

    @GetMapping("all")
    public StudentsDTO findAllStudents()
    {
        return m_studentService.findAllStudents();
    }

    @GetMapping("{id}")
    public Optional<StudentDTO> findStudentById(@PathVariable int id)
    {
        return m_studentService.findStudentById(id);
    }

    @GetMapping("department/{department}")
    public StudentsDTO findStudentsByDepartment(@PathVariable String department, @RequestParam(name = "fname", required = false) String facultyName)
    {
        try {
            return findStudentsByDepartmentId(Integer.parseInt(department));
        }
        catch (NumberFormatException ex) {
            return facultyName == null ? findStudentsByDepartmentName(department) : m_studentService.findStudentByDepartmentNameAndFacultyName(department, facultyName);
        }
    }

    @GetMapping("faculty/{faculty}")
    StudentsDTO findStudentsByFaculty(@PathVariable String faculty)
    {
        try {
            return findStudentsByFacultyId(Integer.parseInt(faculty));
        }
        catch (NumberFormatException ex) {
            return findStudentsByFacultyName(faculty);
        }
    }

    @GetMapping("courseInstance/{id}")
    StudentsDTO findStudentsByCourseInstanceId(@PathVariable int id)
    {
        return m_studentService.findStudentsByCourseInstanceId(id);
    }

    @GetMapping("age/{age}")
    StudentsDTO findStudentsByAge(@PathVariable int age)
    {
        return m_studentService.findStudentsByAge(age);
    }

    @GetMapping("age/greater/{age}")
    StudentsDTO findStudentsByAgeGreaterThan(@PathVariable int age)
    {
        return m_studentService.findStudentsByAgeGreaterThan(age);
    }

    @GetMapping("age/less/{age}")
    StudentsDTO findStudentsByAgeLessThan(@PathVariable int age)
    {
        return m_studentService.findStudentsByAgeLessThan(age);
    }

    @GetMapping("names")
    StudentsDTO findStudentsByNames(@RequestParam("fname") String firstName, @RequestParam(name = "mname", required = false) String middleName, @RequestParam("lname") String lastName)
    {
        return m_studentService.findStudentsByNames(firstName, middleName, lastName);
    }

    private StudentsDTO findStudentsByDepartmentId(int id)
    {
        return m_studentService.findStudentByDepartmentId(id);
    }

    private StudentsDTO findStudentsByDepartmentName(String name)
    {
        return m_studentService.findStudentByDepartmentName(name);
    }

    private StudentsDTO findStudentsByFacultyId(int id)
    {
        return m_studentService.findStudentsByFacultyId(id);
    }

    private StudentsDTO findStudentsByFacultyName(String name)
    {
        return m_studentService.findStudentsByFacultyName(name);
    }
}
