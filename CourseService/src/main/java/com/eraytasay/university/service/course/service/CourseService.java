package com.eraytasay.university.service.course.service;

import com.eraytasay.university.data.dal.CourseServiceHelper;
import com.eraytasay.university.service.course.dto.CourseDTO;
import com.eraytasay.university.service.course.dto.CourseSaveDTO;
import com.eraytasay.university.service.course.dto.CoursesDTO;
import com.eraytasay.university.service.course.mapper.ICourseMapper;
import com.eraytasay.university.service.course.mapper.ICourseSaveDTOMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private final CourseServiceHelper m_courseServiceHelper;
    private final ICourseMapper m_courseMapper;
    private final ICourseSaveDTOMapper m_courseSaveDTOMapper;

    public CourseService(CourseServiceHelper courseServiceHelper, ICourseMapper courseMapper, ICourseSaveDTOMapper courseSaveDTOMapper)
    {
        m_courseServiceHelper = courseServiceHelper;
        m_courseMapper = courseMapper;
        m_courseSaveDTOMapper = courseSaveDTOMapper;
    }

    public CoursesDTO findAllCourses()
    {
        return m_courseMapper.toCoursesDTO(m_courseServiceHelper.findAllCourses()) ;
    }

    public Optional<CourseDTO> findCourseById(int id)
    {
        return m_courseServiceHelper.findCourseById(id).map(m_courseMapper::toCourseDTO);
    }

    public Optional<CourseDTO> findCourseByCode(String code)
    {
        return m_courseServiceHelper.findCourseByCode(code).map(m_courseMapper::toCourseDTO);
    }

    public Optional<CourseDTO> findCourseByName(String name)
    {
        return m_courseServiceHelper.findCourseByName(name).map(m_courseMapper::toCourseDTO);
    }

    public CourseDTO saveCourse(CourseSaveDTO courseSave)
    {
        var savedCourse = m_courseServiceHelper.saveCourse(m_courseSaveDTOMapper.toCourse(courseSave));
        return m_courseMapper.toCourseDTO(savedCourse);
    }
}
