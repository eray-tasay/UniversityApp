package com.eraytasay.university.service.get.lecturer.controller;

import com.eraytasay.university.service.get.lecturer.dto.LecturerDTO;
import com.eraytasay.university.service.get.lecturer.dto.LecturersDTO;
import com.eraytasay.university.service.get.lecturer.service.LecturerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/get/lecturers")
public class LecturerController {
    private final LecturerService m_lecturerService;

    public LecturerController(LecturerService lecturerService)
    {
        m_lecturerService = lecturerService;
    }

    @GetMapping("all")
    public LecturersDTO findAllLecturers()
    {
        return m_lecturerService.findAllLecturers();
    }

    @GetMapping
    public Optional<LecturerDTO> findLecturerByCitizenId(@RequestParam("cid") String citizenId)
    {
        return m_lecturerService.findLecturerByCitizenId(citizenId);
    }

    @GetMapping("{id}")
    public Optional<LecturerDTO> findLecturerById(@PathVariable int id)
    {
        return m_lecturerService.findLecturerById(id);
    }
}
