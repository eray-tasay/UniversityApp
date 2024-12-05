package com.eraytasay.university.service.post.student.service;

import com.eraytasay.university.data.dal.StudentPostServiceHelper;
import com.eraytasay.university.data.entity.dto.StudentSaveDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentPostServiceHelper m_studentPostServiceHelper;

    public StudentService(StudentPostServiceHelper studentPostServiceHelper)
    {
        m_studentPostServiceHelper = studentPostServiceHelper;
    }

    public void saveStudent(StudentSaveDTO studentSaveDTO)
    {
        //m_studentPostServiceHelper.saveStudent();
    }
}
