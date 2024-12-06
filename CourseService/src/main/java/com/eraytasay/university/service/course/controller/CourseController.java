package com.eraytasay.university.service.course.controller;

import com.eraytasay.university.service.course.dto.CourseDTO;
import com.eraytasay.university.service.course.dto.CourseSaveDTO;
import com.eraytasay.university.service.course.dto.CoursesDTO;
import com.eraytasay.university.service.course.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CourseController {
    private final CourseService m_courseService;

    public CourseController(CourseService courseService)
    {
        m_courseService = courseService;
    }

    @GetMapping("/api/get/courses/all")
    public CoursesDTO findAllCourses()
    {
        return m_courseService.findAllCourses();
    }

    @GetMapping("/api/get/courses/{id}")
    public Optional<CourseDTO> findCourseById(@PathVariable int id)
    {
        return m_courseService.findCourseById(id);
    }

    @GetMapping("/api/get/courses/code/{code}")
    public Optional<CourseDTO> findCourseByCode(@PathVariable String code)
    {
        return m_courseService.findCourseByCode(code);
    }

    @GetMapping("/api/get/courses/name/{name}")
    public Optional<CourseDTO> findCourseByName(@PathVariable String name)
    {
        return m_courseService.findCourseByName(name);
    }

    @PostMapping("/api/post/courses")
    public CourseDTO saveCourse(@RequestBody CourseSaveDTO courseSave)
    {
        return m_courseService.saveCourse(courseSave);
    }
}
