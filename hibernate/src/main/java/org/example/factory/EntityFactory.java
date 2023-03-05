package org.example.factory;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;

public interface EntityFactory {

    TeacherEntity createTeacher();
    StudentEntity createStudent();
    CourseEntity createCourse();
}
