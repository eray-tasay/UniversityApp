package com.eraytasay.university.data.entity.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StudentSaveWithDepartmentNamesDTO extends StudentSaveDTO {
    @JsonProperty(required = true)
    public List<String> departments;
}
