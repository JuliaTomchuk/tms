package org.example.service;


import org.example.domain.StudentEntity;

public interface StudentService {
    void save(StudentEntity student);

    StudentEntity get(Integer id);

    boolean delete(Integer id);

    boolean addStudentToCourse(Integer studentId, Integer courseId);
    boolean deleteStudentFromCourse (Integer studentId, Integer courseId);
}
