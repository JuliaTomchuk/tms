package org.example.config;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "14271915");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        properties.put(Environment.SHOW_SQL, "true");

        configuration.addProperties(properties);
        configuration.addAnnotatedClass(TeacherEntity.class);
        configuration.addAnnotatedClass(CourseEntity.class);
        configuration.addAnnotatedClass(StudentEntity.class);
        return configuration.buildSessionFactory();

    }


}
