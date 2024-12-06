package com.eraytasay.university.service.get.lecturer.dto;

import java.util.List;

public class LecturersDTO {
    public List<LecturerDTO> lecturers;

    public LecturersDTO(List<LecturerDTO> lecturers)
    {
        this.lecturers = lecturers;
    }
}
