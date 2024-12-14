package com.eraytasay.university.service.studentcourseinstance.service;

import com.eraytasay.university.data.dal.StudentToCourseInstanceServiceHelper;
import com.eraytasay.university.data.entity.dto.studentcourseinstance.StudentToCourseInstanceSaveDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentToCourseInstanceService {
    private final StudentToCourseInstanceServiceHelper m_studentToCourseInstanceServiceHelper;

    public StudentToCourseInstanceService(StudentToCourseInstanceServiceHelper studentToCourseInstanceServiceHelper)
    {
        m_studentToCourseInstanceServiceHelper = studentToCourseInstanceServiceHelper;
    }

    public boolean saveStudentToCourseInstance(StudentToCourseInstanceSaveDTO studentToCourseInstanceSaveDTO)
    {
        return m_studentToCourseInstanceServiceHelper.saveStudentToCourseInstance(studentToCourseInstanceSaveDTO);
    }
}
