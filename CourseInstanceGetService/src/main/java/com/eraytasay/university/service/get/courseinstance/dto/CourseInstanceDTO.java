package com.eraytasay.university.service.get.courseinstance.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseInstanceDTO {
    public int id;
    public CourseDTO course;
    public String lecturerFullName;
    public SemesterDTO semester;
    public LocalTime startTime;
    public LocalTime endTime;
    public DayOfWeek dayOfWeek;
    public String classroom;
}
