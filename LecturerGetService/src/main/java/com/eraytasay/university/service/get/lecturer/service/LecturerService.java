package com.eraytasay.university.service.get.lecturer.service;

import com.eraytasay.university.data.dal.LecturerServiceHelper;
import com.eraytasay.university.service.get.lecturer.dto.LecturerDTO;
import com.eraytasay.university.service.get.lecturer.dto.LecturersDTO;
import com.eraytasay.university.service.get.lecturer.mapper.ILecturerMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LecturerService {
    private final LecturerServiceHelper m_lecturerServiceHelper;
    private final ILecturerMapper m_lecturerMapper;

    public LecturerService(LecturerServiceHelper lecturerServiceHelper, ILecturerMapper lecturerMapper)
    {
        m_lecturerServiceHelper = lecturerServiceHelper;
        m_lecturerMapper = lecturerMapper;
    }

    public LecturersDTO findAllLecturers()
    {
        return m_lecturerMapper.toLecturersDTO(m_lecturerServiceHelper.findAllLecturers());
    }

    public Optional<LecturerDTO> findLecturerByCitizenId(String citizenId)
    {
        return m_lecturerServiceHelper.findLecturerByCitizenId(citizenId).map(m_lecturerMapper::toLecturerDTO);
    }

    public Optional<LecturerDTO> findLecturerById(int id)
    {
        return m_lecturerServiceHelper.findLecturerById(id).map(m_lecturerMapper::toLecturerDTO);
    }
}
