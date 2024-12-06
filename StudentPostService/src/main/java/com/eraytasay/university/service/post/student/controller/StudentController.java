package com.eraytasay.university.service.post.student.controller;

import com.eraytasay.university.data.entity.dto.student.StudentSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.student.StudentSaveWithDepartmentNamesDTO;
import com.eraytasay.university.data.exception.department.NoSuchDepartmentException;
import com.eraytasay.university.data.exception.department.NotUniqueDepartmentException;
import com.eraytasay.university.service.post.student.exception.unique.NotUniqueCitizenIdException;
import com.eraytasay.university.service.post.student.exception.unique.NotUniqueEmailException;
import com.eraytasay.university.service.post.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/students")
public class
StudentController {
    private final StudentService m_studentService;

    public StudentController(StudentService studentService)
    {
        m_studentService = studentService;
    }

    @PostMapping("department/name")
    public ResponseEntity<Object> saveStudentWithDepartmentNames(@RequestBody StudentSaveWithDepartmentNamesDTO studentSave)
    {
        try {
            return ResponseEntity.ok(m_studentService.saveStudentWithDepartmentNames(studentSave));
        }
        catch (NoSuchDepartmentException | NotUniqueDepartmentException | NotUniqueCitizenIdException | NotUniqueEmailException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @PostMapping("department/id")
    public ResponseEntity<Object> saveStudentWithDepartmentIds(@RequestBody StudentSaveWithDepartmentIdsDTO studentSave)
    {
        try {
            return ResponseEntity.ok(m_studentService.saveStudentWithDepartmentIds(studentSave));
        }
        catch (NoSuchDepartmentException | NotUniqueDepartmentException | NotUniqueCitizenIdException | NotUniqueEmailException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }
}
