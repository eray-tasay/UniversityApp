package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceDTO;
import com.eraytasay.university.data.repository.ICourseInstanceRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseInstanceServiceHelper {
    private final ICourseInstanceRepository m_courseInstanceRepository;

    public CourseInstanceServiceHelper(ICourseInstanceRepository courseInstanceRepository)
    {
        m_courseInstanceRepository = courseInstanceRepository;
    }

    public Iterable<CourseInstanceDTO> findCourseInstancesByStudentId(int studentId)
    {
        return m_courseInstanceRepository.findCourseInstancesByStudentId(studentId);
    }

    public Iterable<CourseInstanceDTO> findCourseInstancesByLecturerId(int lecturerId)
    {
        return m_courseInstanceRepository.findCourseInstancesByLecturerId(lecturerId);
    }
}
