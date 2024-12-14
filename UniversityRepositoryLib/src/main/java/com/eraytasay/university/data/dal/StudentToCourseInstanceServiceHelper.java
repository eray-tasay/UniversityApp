package com.eraytasay.university.data.dal;

import com.eraytasay.university.data.entity.dto.studentcourseinstance.StudentToCourseInstanceSaveDTO;
import com.eraytasay.university.data.entity.orm.CourseInstance;
import com.eraytasay.university.data.entity.orm.Student;
import com.eraytasay.university.data.entity.orm.StudentToCourseInstance;
import com.eraytasay.university.data.repository.IStudentToCourseInstanceRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentToCourseInstanceServiceHelper {
    private final IStudentToCourseInstanceRepository m_studentToCourseInstanceRepository;

    public StudentToCourseInstanceServiceHelper(IStudentToCourseInstanceRepository studentToCourseInstanceRepository)
    {
        m_studentToCourseInstanceRepository = studentToCourseInstanceRepository;
    }

    public boolean saveStudentToCourseInstance(StudentToCourseInstanceSaveDTO studentToCourseInstanceSaveDTO)
    {
        try {
            m_studentToCourseInstanceRepository.save(getStudentToCourseInstance(studentToCourseInstanceSaveDTO));
            return true;
        }
        catch (RuntimeException ex) {
            return false;
        }
    }

    private StudentToCourseInstance getStudentToCourseInstance(StudentToCourseInstanceSaveDTO studentToCourseInstanceSaveDTO)
    {
        var res = new StudentToCourseInstance();

        res.student = getStudent(studentToCourseInstanceSaveDTO.studentId);
        res.courseInstance = getCourseInstance(studentToCourseInstanceSaveDTO.courseInstanceId);

        return res;
     }

     private Student getStudent(int id)
     {
         var student = new Student();

         student.id = id;
         return student;
     }

     private CourseInstance getCourseInstance(int id)
     {
         var courseInstance = new CourseInstance();

         courseInstance.id = id;
         return courseInstance;
     }
}
