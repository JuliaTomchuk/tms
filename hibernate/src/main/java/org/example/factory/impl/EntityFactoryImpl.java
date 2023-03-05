package org.example.factory.impl;

import org.example.domain.CourseEntity;
import org.example.domain.CourseSchedule;
import org.example.domain.CourseType;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.factory.EntityFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class EntityFactoryImpl implements EntityFactory {
    private Random random = new Random();

    @Override
    public TeacherEntity createTeacher() {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName("John" + random.nextInt());
        teacher.setBirthday(LocalDate.now());
        teacher.setInsuranceNumber(11111L + random.nextLong());
        return teacher;
    }

    @Override
    public StudentEntity createStudent() {
        StudentEntity student = new StudentEntity();
        student.setName("Robert" + random.nextInt());
        student.setInsuranceNumber(22222L + random.nextLong());
        return student;
    }

    @Override
    public CourseEntity createCourse() {
        CourseEntity course = new CourseEntity();
        course.setSchedule(new CourseSchedule(LocalDate.of(2020, 12, 10), LocalDate.of(2022, 10, 20)));
        course.setType(CourseType.OFFLINE);
        course.setAvailableForEnrolling(true);
        course.setName("Java" + random.nextInt());
        course.setGroupNumber(33333L + random.nextLong());
        return course;
    }
}
