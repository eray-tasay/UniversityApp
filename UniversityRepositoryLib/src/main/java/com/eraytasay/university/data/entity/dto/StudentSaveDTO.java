package com.eraytasay.university.data.entity.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentSaveDTO {
    public String firstName;
    public String middleName;
    public String lastName;
    public String citizenId;
    public LocalDate birthDate;
    public List<String> departments;
}
