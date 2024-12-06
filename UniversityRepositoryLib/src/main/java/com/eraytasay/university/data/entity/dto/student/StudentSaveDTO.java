package com.eraytasay.university.data.entity.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class StudentSaveDTO {
    @JsonProperty(required = true)
    public String firstName;

    public String middleName;

    @JsonProperty(required = true)
    public String lastName;

    @JsonProperty(required = true)
    public String email;

    @JsonProperty(required = true)
    public String citizenId;

    @JsonProperty(required = true)
    public LocalDate birthDate;
}
