package org.example.service.impl;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.service.SessionService;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl extends SessionService implements StudentService {
    @Override
    public void save(StudentEntity student) {
        Session session = getSession();
        session.save(student);
        closeSession(session);
    }

    @Override
    public StudentEntity get(Integer id) {
        Session session = getSession();
        StudentEntity student = session.get(StudentEntity.class, id);
        closeSession(session);
        return student;
    }

    @Override
    public void delete(Integer id) {
        Session session = getSession();
        StudentEntity student = session.get(StudentEntity.class, id);
        session.delete(student);
        closeSession(session);

    }

    @Override
    public void addStudentToCourse(StudentEntity student, CourseEntity course) {
        Session session = getSession();
        if (student.getId() == null) {
            session.save(student);
        }
        if (course.getId() == null) {
            session.save(course);
        }

        List<CourseEntity> courses = student.getCourses();
        if (courses != null) {
            courses.add(course);
        } else {
            courses = new ArrayList<>();
            courses.add(course);
        }
        student.setCourses(courses);
        session.update(student);

        closeSession(session);

    }

    @Override
    public void deleteStudentFromCourse(StudentEntity student, CourseEntity course) {
        Session session = getSession();
        List<CourseEntity> courses = student.getCourses();
        courses.remove(course);
        student.setCourses(courses);
        session.update(student);

        closeSession(session);


    }


}
