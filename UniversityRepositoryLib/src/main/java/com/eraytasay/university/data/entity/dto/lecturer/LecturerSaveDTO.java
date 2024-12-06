package com.eraytasay.university.data.entity.dto.lecturer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class LecturerSaveDTO {
    @JsonProperty(required = true)
    public String firstName;

    public String middleName;

    @JsonProperty(required = true)
    public String lastName;

    @JsonProperty(required = true)
    public String citizenId;

    @JsonProperty(required = true)
    public String email;

    @JsonProperty(required = true)
    public LocalDate birthDate;
}
