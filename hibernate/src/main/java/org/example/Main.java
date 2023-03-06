package org.example;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.creator.EntitySampleCreator;
import org.example.service.StudentService;
import org.example.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        EntitySampleCreator entityFactory = context.getBean(EntitySampleCreator.class);

        TeacherEntity teacher1 = entityFactory.createTeacher();
        CourseEntity course1 = entityFactory.createCourse();
        CourseEntity course2 = entityFactory.createCourse();
        CourseEntity course3 = entityFactory.createCourse();

        TeacherService teacherService = context.getBean(TeacherService.class);

        teacher1.setCourses(List.of(course1, course2, course3));
        teacherService.save(teacher1);

        StudentService studentService = context.getBean(StudentService.class);
        StudentEntity student1 = entityFactory.createStudent();
        StudentEntity student2 = entityFactory.createStudent();
        StudentEntity student3 = entityFactory.createStudent();

        studentService.addStudentToCourse(student1, course1);
        studentService.addStudentToCourse(student1, course2);
        studentService.addStudentToCourse(student1, course3);
        studentService.addStudentToCourse(student2, course2);
        studentService.addStudentToCourse(student3, course2);


        TeacherEntity teacher = teacherService.get(1);
        System.out.println(teacher);
        System.out.println("--------------------------------------------");

        studentService.deleteStudentFromCourse(student1, course1);
        studentService.deleteStudentFromCourse(student1, course2);
        studentService.deleteStudentFromCourse(student1, course3);

        TeacherEntity teacher2 = teacherService.get(1);
        System.out.println(teacher2);

    }
}