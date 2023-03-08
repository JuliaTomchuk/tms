package org.example.service;

import org.example.domain.CourseEntity;

public interface CourseService {
    void save(CourseEntity course);

    CourseEntity get(Integer id);

    boolean delete(Integer id);
}
