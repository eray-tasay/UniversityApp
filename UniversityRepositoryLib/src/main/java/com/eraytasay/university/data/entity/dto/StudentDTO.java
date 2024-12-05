package com.eraytasay.university.data.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    public int id;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
    public String email;
    public String citizenId;
    public LocalDate birthDate;
    public List<String> departments;
}
