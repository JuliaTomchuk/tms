package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.domain.TeacherEntity;
import org.example.service.SessionService;
import org.example.service.TeacherService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl extends SessionService implements TeacherService {


    @Override
    public void save(TeacherEntity teacher) {
        Session session = getSession();
        session.save(teacher);
        closeSession(session);
        session.close();
    }

    @Override
    public TeacherEntity get(Integer id) {
        Session session = getSession();
        TeacherEntity teacher = session.get(TeacherEntity.class, id);
        closeSession(session);
        return teacher;
    }

    @Override
    public void delete(Integer id) {
        Session session = getSession();
        TeacherEntity teacher = session.get(TeacherEntity.class,id);
        session.delete(teacher);
        closeSession(session);


    }
}
