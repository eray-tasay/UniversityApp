package com.eraytasay.university.service.course.dto;

import java.util.List;

public class CoursesDTO {
    public List<CourseDTO> courses;

    public CoursesDTO(List<CourseDTO> courses)
    {
        this.courses = courses;
    }
}
