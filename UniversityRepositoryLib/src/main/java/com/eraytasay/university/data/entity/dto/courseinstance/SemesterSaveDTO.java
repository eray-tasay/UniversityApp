package com.eraytasay.university.data.entity.dto.courseinstance;

import com.eraytasay.university.data.entity.orm.SemesterType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SemesterSaveDTO {
    @JsonProperty(required = true)
    public int year;

    @JsonProperty(required = true)
    public SemesterType type;
}
