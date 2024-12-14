package com.eraytasay.university.data.entity.dto.studentcourseinstance;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentToCourseInstanceSaveDTO {
    @JsonProperty(required = true)
    public int studentId;
    @JsonProperty(required = true)
    public int courseInstanceId;
}
