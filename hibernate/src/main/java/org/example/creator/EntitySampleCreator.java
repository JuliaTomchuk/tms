package org.example.creator;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;

public interface EntitySampleCreator {

    TeacherEntity createTeacher();
    StudentEntity createStudent();
    CourseEntity createCourse();
}
