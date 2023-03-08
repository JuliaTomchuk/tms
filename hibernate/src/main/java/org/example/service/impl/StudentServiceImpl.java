package org.example.service.impl;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.service.SessionService;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentServiceImpl extends SessionService implements StudentService {
    @Override
    public void save(StudentEntity student) {
        Session session = getSession();
        session.persist(student);
        closeSession(session);
    }

    @Override
    public StudentEntity get(Integer id) {
        Session session = getSession();
        Optional <StudentEntity> studentOptional = Optional.ofNullable(session.get(StudentEntity.class, id));
        closeSession(session);
        return studentOptional.orElse(new StudentEntity());
    }

    @Override
    public boolean delete(Integer id) {
        Session session = getSession();
        boolean isDeleted=false;
        Optional <StudentEntity> studentOptional = Optional.ofNullable(session.get(StudentEntity.class, id));
        if(studentOptional.isPresent()){
            StudentEntity student = studentOptional.get();
            session.delete(student);
            isDeleted=true;
        }
          closeSession(session);
        return isDeleted;
    }

    @Override
    public boolean addStudentToCourse(Integer studentId, Integer courseId) {
        boolean isAdded =false;
        Session session = getSession();
        Optional <StudentEntity> studentOptional = Optional.ofNullable(session.get(StudentEntity.class, studentId));
        Optional <CourseEntity> courseOptional = Optional.ofNullable(session.get(CourseEntity.class,courseId));
        if(studentOptional.isPresent()&&courseOptional.isPresent()){
            courseOptional.get().addStudent(studentOptional.get());
            isAdded=true;
        }

        closeSession(session);
        return isAdded;
    }

    @Override
    public boolean deleteStudentFromCourse(Integer studentId, Integer courseId) {
        boolean isDeleted= false;
        Session session = getSession();
        Optional <StudentEntity> studentOptional = Optional.ofNullable(session.get(StudentEntity.class, studentId));
        Optional <CourseEntity> courseOptional = Optional.ofNullable(session.get(CourseEntity.class,courseId));

        if(studentOptional.isPresent()&&courseOptional.isPresent()){
            courseOptional.get().deleteStudent(studentOptional.get());
            isDeleted = true;
        }

        closeSession(session);
        return isDeleted;
    }


}
