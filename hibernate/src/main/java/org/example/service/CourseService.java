package org.example.service;

import org.example.domain.CourseEntity;

public interface CourseService {
    void save(CourseEntity courseEntity);

    CourseEntity get(int id);

    void delete(int id);
}
