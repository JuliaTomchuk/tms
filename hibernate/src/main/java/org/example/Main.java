package org.example;

import org.example.domain.CourseEntity;
import org.example.domain.CourseSchedule;
import org.example.domain.CourseType;
import org.example.domain.TeacherEntity;
import org.example.service.CourseService;
import org.example.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName("John");
        teacher.setBirthday(LocalDate.now());

        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.save(teacher);
        CourseEntity course = new CourseEntity();
        course.setType(CourseType.OFFLINE);
        course.setName("Java");
        course.setSchedule(new CourseSchedule(LocalDate.of(2020,10,23),LocalDate.of(2021,10,19)));
        course.setAvailableForEnrolling(true);
        course.setTeacher(teacher);

        CourseService courseService = context.getBean(CourseService.class);
        courseService.save(course);




    }
}