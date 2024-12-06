package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.orm.Course;
import com.eraytasay.university.data.repository.ICourseRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseServiceHelper {
    private final ICourseRepository m_courseRepository;

    public CourseServiceHelper(ICourseRepository courseRepository)
    {
        m_courseRepository = courseRepository;
    }

    public Iterable<Course> findAllCourses()
    {
        return m_courseRepository.findAll();
    }

    public Optional<Course> findCourseById(int id)
    {
        return m_courseRepository.findById(id);
    }

    public Optional<Course> findCourseByCode(String code)
    {
        return m_courseRepository.findCourseByCode(code);
    }

    public Optional<Course> findCourseByName(String name)
    {
        return m_courseRepository.findCourseByName(name);
    }

    public Course saveCourse(Course course)
    {
        return m_courseRepository.save(course);
    }
}
