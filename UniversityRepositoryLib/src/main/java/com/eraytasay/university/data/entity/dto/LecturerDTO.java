package com.eraytasay.university.data.entity.dto;

import java.time.LocalDate;
import java.util.List;

public class LecturerDTO {
    public int id;
    public String firstName;
    public String middleName;
    public String lastName;
    public String citizenId;
    public String email;
    public LocalDate birthDate;
    public List<String> departments;
}
