package org.example.service.impl;

import org.example.domain.CourseEntity;
import org.example.service.CourseService;
import org.example.service.SessionService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl extends SessionService implements CourseService {


    @Override
    public void save(CourseEntity courseEntity) {

        Session session = getSession();
        session.persist(courseEntity);
        closeSession(session);

    }


    @Override
    public CourseEntity get(Integer id) {
        Session session = getSession();
       Optional<CourseEntity> courseEntity = Optional.ofNullable(session.get(CourseEntity.class, id));
        closeSession(session);
        return courseEntity.orElse(new CourseEntity());
    }

    @Override
    public boolean delete(Integer id) {
        Session session = getSession();
        boolean isDeleted=false;
        Optional <CourseEntity> courseOptional = Optional.ofNullable(session.get(CourseEntity.class, id));
        if(courseOptional.isPresent()){
            CourseEntity course = courseOptional.get();
        session.delete(course);
        isDeleted=true;
        }
        closeSession(session);
        session.close();
        return isDeleted;
    }
}
