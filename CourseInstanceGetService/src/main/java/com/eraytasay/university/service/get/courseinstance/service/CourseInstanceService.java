package com.eraytasay.university.service.get.courseinstance.service;

import com.eraytasay.university.data.dal.CourseInstanceServiceHelper;
import com.eraytasay.university.service.get.courseinstance.dto.CourseInstancesDTO;
import com.eraytasay.university.service.get.courseinstance.mapper.ICourseInstanceDTOMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseInstanceService {
    private final CourseInstanceServiceHelper m_courseInstanceServiceHelper;
    private final ICourseInstanceDTOMapper m_courseInstanceMapper;

    public CourseInstanceService(CourseInstanceServiceHelper courseInstanceServiceHelper, ICourseInstanceDTOMapper courseInstanceMapper)
    {
        m_courseInstanceServiceHelper = courseInstanceServiceHelper;
        m_courseInstanceMapper = courseInstanceMapper;
    }

    public CourseInstancesDTO findCourseInstancesByStudentId(int studentId)
    {
        return m_courseInstanceMapper.toCourseInstancesDTO(m_courseInstanceServiceHelper.findCourseInstancesByStudentId(studentId));
    }

    public CourseInstancesDTO findCourseInstancesByLecturerId(int lecturerId)
    {
        return m_courseInstanceMapper.toCourseInstancesDTO(m_courseInstanceServiceHelper.findCourseInstancesByLecturerId(lecturerId));
    }
}
