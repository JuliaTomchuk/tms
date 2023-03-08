package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.domain.TeacherEntity;
import org.example.service.SessionService;
import org.example.service.TeacherService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherServiceImpl extends SessionService implements TeacherService {


    @Override
    public void save(TeacherEntity teacher) {
        Session session = getSession();
        session.persist(teacher);
        closeSession(session);
        session.close();
    }

    @Override
    public TeacherEntity get(Integer id) {
        Session session = getSession();
        Optional<TeacherEntity> teacher = Optional.ofNullable( session.get(TeacherEntity.class, id));
        closeSession(session);
        return teacher.orElse(new TeacherEntity());
    }

    @Override
    public boolean delete(Integer id) {
        Session session = getSession();
        boolean isDeleted = false;
       Optional <TeacherEntity> teacherOptional = Optional.ofNullable(session.get(TeacherEntity.class,id));
       if(teacherOptional.isPresent()){
           TeacherEntity teacher = teacherOptional.get();
           session.delete(teacher);
           isDeleted=true;
       }
        closeSession(session);
       return isDeleted;
    }
}
