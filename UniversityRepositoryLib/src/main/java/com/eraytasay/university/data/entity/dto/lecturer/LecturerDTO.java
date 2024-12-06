package com.eraytasay.university.data.entity.dto.lecturer;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

public class LecturerDTO {
    public int id;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
    public String citizenId;
    public String email;
    public LocalDate birthDate;
    public List<String> departments;
}
