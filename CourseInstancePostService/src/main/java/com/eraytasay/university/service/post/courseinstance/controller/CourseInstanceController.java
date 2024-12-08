package com.eraytasay.university.service.post.courseinstance.controller;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceSaveDTO;
import com.eraytasay.university.service.post.courseinstance.service.CourseInstanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/courseInstances")
public class CourseInstanceController {
    private final CourseInstanceService m_courseInstanceService;

    public CourseInstanceController(CourseInstanceService courseInstanceService)
    {
        m_courseInstanceService = courseInstanceService;
    }

    @PostMapping
    public CourseInstanceSaveDTO saveCourseInstance(@RequestBody CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
        return m_courseInstanceService.saveCourseInstance(courseInstanceSaveDTO);
    }
}
