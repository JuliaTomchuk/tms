package org.example.service;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;

public interface StudentService {
    void save(StudentEntity t);

    StudentEntity get(Integer id);

    void delete(Integer id);

    void addStudentToCourse(StudentEntity student, CourseEntity course);
    void deleteStudentFromCourse (StudentEntity student, CourseEntity course);
}
