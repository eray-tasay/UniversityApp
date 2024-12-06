package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.orm.Lecturer;
import com.eraytasay.university.data.repository.ILecturerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LecturerServiceHelper {
    private final ILecturerRepository m_lecturerRepository;

    public LecturerServiceHelper(ILecturerRepository lecturerRepository)
    {
        m_lecturerRepository = lecturerRepository;
    }

    public Iterable<Lecturer> findAllLecturers()
    {
        return m_lecturerRepository.findAll();
    }

    public Optional<Lecturer> findLecturerByCitizenId(String citizenId)
    {
        return m_lecturerRepository.findLecturerByCitizenId(citizenId);
    }

    public Optional<Lecturer> findLecturerById(int id)
    {
        return m_lecturerRepository.findById(id);
    }
}
