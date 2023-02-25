package org.example.service;

import org.example.domain.TeacherEntity;

public interface TeacherService {
    void save(TeacherEntity teacher);
    TeacherEntity get(int id);
    void delete (int id);

}
