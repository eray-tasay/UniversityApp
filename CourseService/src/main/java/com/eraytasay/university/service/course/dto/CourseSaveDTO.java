package com.eraytasay.university.service.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseSaveDTO {
    @JsonProperty(required = true)
    public String code;

    @JsonProperty(required = true)
    public String name;
}
