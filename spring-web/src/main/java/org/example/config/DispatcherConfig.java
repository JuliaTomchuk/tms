package org.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class DispatcherConfig implements WebApplicationInitializer {

    @Override public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("org.example");
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new
                DispatcherServlet(context));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }}
