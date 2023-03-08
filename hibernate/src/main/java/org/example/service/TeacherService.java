package org.example.service;

import org.example.domain.TeacherEntity;

public interface TeacherService {
    void save(TeacherEntity teacher);

    TeacherEntity get(Integer id);

    boolean delete(Integer id);

}
