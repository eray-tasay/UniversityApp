package com.eraytasay.university.data.entity.dto.courseinstance;

import com.eraytasay.university.data.entity.orm.Classroom;
import com.eraytasay.university.data.entity.orm.Course;
import com.eraytasay.university.data.entity.orm.Lecturer;
import com.eraytasay.university.data.entity.orm.Semester;
import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@AllArgsConstructor
public class CourseInstanceDTO {
    public int id;
    public Course course;
    public Lecturer lecturer;
    public Semester semester;
    public LocalTime startTime;
    public LocalTime endTime;
    public DayOfWeek dayOfWeek;
    public Classroom classroom;
}
