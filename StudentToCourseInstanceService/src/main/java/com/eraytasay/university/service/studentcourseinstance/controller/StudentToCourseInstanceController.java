package com.eraytasay.university.service.studentcourseinstance.controller;

import com.eraytasay.university.data.entity.dto.studentcourseinstance.StudentToCourseInstanceSaveDTO;
import com.eraytasay.university.service.studentcourseinstance.service.StudentToCourseInstanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentToCourseInstanceController {
    private final StudentToCourseInstanceService m_studentToCourseInstanceService;

    public StudentToCourseInstanceController(StudentToCourseInstanceService studentToCourseInstanceService)
    {
        m_studentToCourseInstanceService = studentToCourseInstanceService;
    }

    @PostMapping("/api/post/studentToCourseInstances")
    public boolean saveStudentToCourseInstances(@RequestBody StudentToCourseInstanceSaveDTO studentToCourseInstanceSaveDTO)
    {
        return m_studentToCourseInstanceService.saveStudentToCourseInstance(studentToCourseInstanceSaveDTO);
    }
}
