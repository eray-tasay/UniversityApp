package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceSaveDTO;
import com.eraytasay.university.data.exception.department.NoSuchCourseException;
import com.eraytasay.university.data.mapper.ICourseInstanceSaveDTOMapper;
import com.eraytasay.university.data.repository.ICourseInstanceRepository;
import com.eraytasay.university.data.repository.ICourseRepository;
import com.eraytasay.university.data.repository.ISemesterRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CourseInstancePostServiceHelper {
    private final ICourseRepository m_courseRepository;
    private final ICourseInstanceRepository m_courseInstanceRepository;
    private final ISemesterRepository m_semesterRepository;
    private final ICourseInstanceSaveDTOMapper m_courseInstanceSaveDTOMapper;

    public CourseInstancePostServiceHelper(ICourseRepository courseRepository, ICourseInstanceRepository courseInstanceRepository,
                                           ISemesterRepository semesterRepository, ICourseInstanceSaveDTOMapper courseInstanceSaveDTOMapper)
    {
        m_courseRepository = courseRepository;
        m_courseInstanceRepository = courseInstanceRepository;
        m_semesterRepository = semesterRepository;
        m_courseInstanceSaveDTOMapper = courseInstanceSaveDTOMapper;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public CourseInstanceSaveDTO saveCourseInstance(CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
        var semesterOpt = m_semesterRepository.findSemesterByYearAndType(courseInstanceSaveDTO.year, courseInstanceSaveDTO.semesterType);
        var semester = semesterOpt.orElseGet(() -> m_semesterRepository.save(m_courseInstanceSaveDTOMapper.toSemester(courseInstanceSaveDTO)));
        var course = m_courseRepository.findCourseByCode(courseInstanceSaveDTO.courseCode).orElseThrow(() ->
                new NoSuchCourseException("There is no course that has %s course code".formatted(courseInstanceSaveDTO.courseCode)));
        var lecturer = m_courseInstanceSaveDTOMapper.toLecturer(courseInstanceSaveDTO);
        var courseInstance = m_courseInstanceSaveDTOMapper.toCourseInstance(courseInstanceSaveDTO);

        courseInstance.course = course;
        courseInstance.semester = semester;
        courseInstance.lecturer = lecturer;

        var saved = m_courseInstanceRepository.save(courseInstance);

        courseInstanceSaveDTO.id = saved.id;
        return courseInstanceSaveDTO;
    }
}
