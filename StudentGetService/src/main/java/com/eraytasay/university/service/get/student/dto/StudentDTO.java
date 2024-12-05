package com.eraytasay.university.service.get.student.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    public int id;
    public String fullName;
    public String email;
    public String citizenId;
    public LocalDate birthDate;
    public List<String> departments;
}
