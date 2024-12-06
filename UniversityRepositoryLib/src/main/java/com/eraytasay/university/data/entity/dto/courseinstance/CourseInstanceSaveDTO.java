package com.eraytasay.university.data.entity.dto.courseinstance;

import com.eraytasay.university.data.entity.orm.SemesterType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseInstanceSaveDTO {
    public int id;
    public String courseCode;
    public int lecturerId;
    public int year;
    public SemesterType semesterType;
    public LocalTime startTime;
    public LocalTime endTime;
    public DayOfWeek dayOfWeek;
}
