package com.eraytasay.university.service.post.student.service;

import com.eraytasay.university.data.dal.StudentPostServiceHelper;
import com.eraytasay.university.data.entity.dto.student.StudentDTO;
import com.eraytasay.university.data.entity.dto.student.StudentSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.student.StudentSaveWithDepartmentNamesDTO;
import com.eraytasay.university.service.post.student.exception.unique.NotUniqueCitizenIdException;
import com.eraytasay.university.service.post.student.exception.unique.NotUniqueEmailException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentPostServiceHelper m_studentPostServiceHelper;

    public StudentService(StudentPostServiceHelper studentPostServiceHelper)
    {
        m_studentPostServiceHelper = studentPostServiceHelper;
    }

    public StudentDTO saveStudentWithDepartmentNames(StudentSaveWithDepartmentNamesDTO studentSave)
    {
        try {
            return m_studentPostServiceHelper.saveStudentWithDepartmentNames(studentSave);
        }
        catch (DataIntegrityViolationException ex) {
            handleDataIntegrityViolationException(ex, studentSave.email, studentSave.citizenId);
            throw ex;
        }
    }

    public StudentDTO saveStudentWithDepartmentIds(StudentSaveWithDepartmentIdsDTO studentSave)
    {
        try {
            return m_studentPostServiceHelper.saveStudentWithDepartmentIds(studentSave);
        }
        catch (DataIntegrityViolationException ex) {
            handleDataIntegrityViolationException(ex, studentSave.email, studentSave.citizenId);
            throw ex;
        }
    }

    private void handleDataIntegrityViolationException(DataIntegrityViolationException ex, String email, String citizenId)
    {
        var message = ex.getMessage();

        if (message.contains("unique_email"))
            throw new NotUniqueEmailException("Email %s is already in use".formatted(email), ex);
        if (message.contains("unique_citizen_id"))
            throw new NotUniqueCitizenIdException("Citizen id %s is already in use".formatted(citizenId), ex);
    }
}
