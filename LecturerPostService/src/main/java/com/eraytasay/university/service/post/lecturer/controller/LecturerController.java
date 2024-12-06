package com.eraytasay.university.service.post.lecturer.controller;

import com.eraytasay.university.data.entity.dto.lecturer.LecturerDTO;
import com.eraytasay.university.data.entity.dto.lecturer.LecturerSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.lecturer.LecturerSaveWithDepartmentNamesDTO;
import com.eraytasay.university.service.post.lecturer.service.LecturerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/lecturers")
public class LecturerController {
    private final LecturerService m_lecturerService;

    public LecturerController(LecturerService lecturerService)
    {
        m_lecturerService = lecturerService;
    }

    @PostMapping("department/id")
    public LecturerDTO saveLecturerWithDepartmentIds(@RequestBody LecturerSaveWithDepartmentIdsDTO lecturerSave)
    {
        return m_lecturerService.saveLecturerWithDepartmentIds(lecturerSave);
    }

    @PostMapping("department/name")
    public LecturerDTO saveLecturerWithDepartmentNames(@RequestBody LecturerSaveWithDepartmentNamesDTO lecturerSave)
    {
        return m_lecturerService.saveLecturerWithDepartmentNames(lecturerSave);
    }
}
