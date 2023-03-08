package org.example;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.creator.EntitySampleCreator;
import org.example.service.StudentService;
import org.example.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        EntitySampleCreator entityFactory = context.getBean(EntitySampleCreator.class);

        TeacherEntity teacher1 = entityFactory.createTeacher();

        CourseEntity course1 = entityFactory.createCourse();
        CourseEntity course2 = entityFactory.createCourse();
        CourseEntity course3 = entityFactory.createCourse();

        TeacherService teacherService = context.getBean(TeacherService.class);
        teacher1.addCourse(course1);
        teacher1.addCourse(course2);
        teacher1.addCourse(course3);

        teacherService.save(teacher1);

        StudentEntity student1 = entityFactory.createStudent();
        StudentEntity student2 = entityFactory.createStudent();
        StudentEntity student3 = entityFactory.createStudent();

        StudentService studentService = context.getBean(StudentService.class);

        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);

        studentService.addStudentToCourse(1,2);
        studentService.addStudentToCourse(2,3);
        studentService.addStudentToCourse(3,1);
        studentService.addStudentToCourse(1,1);
        studentService.addStudentToCourse(1,3);

        studentService.deleteStudentFromCourse(3,1);


        TeacherEntity teacher =teacherService.get(1);
        System.out.println(teacher);


    }
}