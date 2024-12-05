package com.eraytasay.university.service.get.student.dto;

import java.util.List;

public class StudentsDTO {
    public List<StudentDTO> students;

    public StudentsDTO(List<StudentDTO> students)
    {
        this.students = students;
    }
}
