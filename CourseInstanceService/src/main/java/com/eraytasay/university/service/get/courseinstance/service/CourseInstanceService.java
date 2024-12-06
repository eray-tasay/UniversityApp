package com.eraytasay.university.service.get.courseinstance.service;

import com.eraytasay.university.data.dal.CourseInstanceServiceHelper;
import org.springframework.stereotype.Service;

@Service
public class CourseInstanceService {
    private final CourseInstanceServiceHelper m_courseInstanceServiceHelper;

    public CourseInstanceService(CourseInstanceServiceHelper courseInstanceServiceHelper)
    {
        m_courseInstanceServiceHelper = courseInstanceServiceHelper;
    }

    //Left here...
}
