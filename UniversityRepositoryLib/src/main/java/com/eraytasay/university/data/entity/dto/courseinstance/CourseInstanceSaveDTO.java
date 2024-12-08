package com.eraytasay.university.data.entity.dto.courseinstance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseInstanceSaveDTO {
    public int id;

    @JsonProperty(required = true)
    public String courseCode;

    @JsonProperty(required = true)
    public int lecturerId;

    @JsonProperty(required = true)
    public SemesterSaveDTO semester;

    @JsonProperty(required = true)
    public String classroom;

    @JsonProperty(required = true)
    public LocalTime startTime;

    @JsonProperty(required = true)
    public LocalTime endTime;

    @JsonProperty(required = true)
    public DayOfWeek dayOfWeek;
}
