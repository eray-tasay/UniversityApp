package com.eraytasay.university.service.post.lecturer.service;

import com.eraytasay.university.data.dal.LecturerPostServiceHelper;
import com.eraytasay.university.data.entity.dto.lecturer.LecturerDTO;
import com.eraytasay.university.data.entity.dto.lecturer.LecturerSaveWithDepartmentIdsDTO;
import com.eraytasay.university.data.entity.dto.lecturer.LecturerSaveWithDepartmentNamesDTO;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {
    private final LecturerPostServiceHelper m_lecturerPostServiceHelper;

    public LecturerService(LecturerPostServiceHelper lecturerPostServiceHelper)
    {
        m_lecturerPostServiceHelper = lecturerPostServiceHelper;
    }

    public LecturerDTO saveLecturerWithDepartmentIds(LecturerSaveWithDepartmentIdsDTO lecturerSave)
    {
        return m_lecturerPostServiceHelper.saveLecturerWithDepartmentIds(lecturerSave);
    }

    public LecturerDTO saveLecturerWithDepartmentNames(LecturerSaveWithDepartmentNamesDTO lecturerSave)
    {
        return m_lecturerPostServiceHelper.saveLecturerWithDepartmentNames(lecturerSave);
    }
}
