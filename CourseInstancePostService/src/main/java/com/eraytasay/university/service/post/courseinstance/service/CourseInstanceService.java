package com.eraytasay.university.service.post.courseinstance.service;

import com.eraytasay.university.data.dal.CourseInstancePostServiceHelper;
import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceSaveDTO;
import org.springframework.stereotype.Service;

@Service
public class CourseInstanceService {
    private final CourseInstancePostServiceHelper m_courseInstancePostServiceHelper;

    public CourseInstanceService(CourseInstancePostServiceHelper courseInstancePostServiceHelper)
    {
        m_courseInstancePostServiceHelper = courseInstancePostServiceHelper;
    }

    public CourseInstanceSaveDTO saveCourseInstance(CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
        return m_courseInstancePostServiceHelper.saveCourseInstance(courseInstanceSaveDTO);
    }
}
