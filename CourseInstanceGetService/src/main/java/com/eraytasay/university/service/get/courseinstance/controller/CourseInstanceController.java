package com.eraytasay.university.service.get.courseinstance.controller;

import com.eraytasay.university.service.get.courseinstance.dto.CourseInstancesDTO;
import com.eraytasay.university.service.get.courseinstance.service.CourseInstanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get/courseInstances")
public class CourseInstanceController {
    private final CourseInstanceService m_courseInstanceService;

    public CourseInstanceController(CourseInstanceService courseInstanceService)
    {
        m_courseInstanceService = courseInstanceService;
    }

    @GetMapping("student/{id}")
    public CourseInstancesDTO findCourseInstancesByStudentId(@PathVariable("id") int studentId)
    {
        return m_courseInstanceService.findCourseInstancesByStudentId(studentId);
    }

    @GetMapping("lecturer/{id}")
    public CourseInstancesDTO findCourseInstancesByLecturerId(@PathVariable("id") int lecturerId)
    {
        return m_courseInstanceService.findCourseInstancesByLecturerId(lecturerId);
    }
}
