package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.courseinstance.CourseInstanceSaveDTO;
import com.eraytasay.university.data.entity.orm.Classroom;
import com.eraytasay.university.data.entity.orm.Course;
import com.eraytasay.university.data.entity.orm.Semester;
import com.eraytasay.university.data.exception.department.NoSuchCourseException;
import com.eraytasay.university.data.mapper.ICourseInstanceSaveDTOMapper;
import com.eraytasay.university.data.repository.IClassroomRepository;
import com.eraytasay.university.data.repository.ICourseInstanceRepository;
import com.eraytasay.university.data.repository.ICourseRepository;
import com.eraytasay.university.data.repository.ISemesterRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CourseInstancePostServiceHelper {
    private final ICourseRepository m_courseRepository;
    private final ICourseInstanceRepository m_courseInstanceRepository;
    private final ISemesterRepository m_semesterRepository;
    private final IClassroomRepository m_classroomRepository;
    private final ICourseInstanceSaveDTOMapper m_courseInstanceSaveDTOMapper;

    public CourseInstancePostServiceHelper(ICourseRepository courseRepository, ICourseInstanceRepository courseInstanceRepository,
                                           ISemesterRepository semesterRepository, IClassroomRepository classroomRepository,
                                           ICourseInstanceSaveDTOMapper courseInstanceSaveDTOMapper)
    {
        m_courseRepository = courseRepository;
        m_courseInstanceRepository = courseInstanceRepository;
        m_semesterRepository = semesterRepository;
        m_courseInstanceSaveDTOMapper = courseInstanceSaveDTOMapper;
        m_classroomRepository = classroomRepository;
    }

    @Transactional
    public CourseInstanceSaveDTO saveCourseInstance(CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
        var courseInstance = m_courseInstanceSaveDTOMapper.toCourseInstance(courseInstanceSaveDTO);

        courseInstance.course = getCourseOrThrowExceptionIfNotExist(courseInstanceSaveDTO);;
        courseInstance.semester =  getSemesterOrSaveIfNotExist(courseInstanceSaveDTO);;
        courseInstance.lecturer =  m_courseInstanceSaveDTOMapper.toLecturer(courseInstanceSaveDTO);
        courseInstance.classroom = getClassroomOrSaveIfNotExist(courseInstanceSaveDTO);

        var saved = m_courseInstanceRepository.save(courseInstance);

        courseInstanceSaveDTO.id = saved.id;
        return courseInstanceSaveDTO;
    }

    private Semester getSemesterOrSaveIfNotExist(CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
        var semesterOpt = m_semesterRepository.findSemesterByYearAndType(courseInstanceSaveDTO.semester.year, courseInstanceSaveDTO.semester.type);

        return semesterOpt.orElseGet(() -> m_semesterRepository.save(m_courseInstanceSaveDTOMapper.toSemester(courseInstanceSaveDTO)));
    }

    private Classroom getClassroomOrSaveIfNotExist(CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
       return m_classroomRepository.findClassroomByDescription(courseInstanceSaveDTO.classroom).orElseGet(() ->
                m_classroomRepository.save(getClassRoom(courseInstanceSaveDTO.classroom)));
    }

    private Course getCourseOrThrowExceptionIfNotExist(CourseInstanceSaveDTO courseInstanceSaveDTO)
    {
        return m_courseRepository.findCourseByCode(courseInstanceSaveDTO.courseCode).orElseThrow(() ->
                new NoSuchCourseException("There is no course that has %s course code".formatted(courseInstanceSaveDTO.courseCode)));
    }

    private Classroom getClassRoom(String description)
    {
        var classroom = new Classroom();

        classroom.description = description;
        return classroom;
    }
}
