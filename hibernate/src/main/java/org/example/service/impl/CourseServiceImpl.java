package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.domain.CourseEntity;
import org.example.service.CourseService;
import org.example.service.DAOService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl extends DAOService  implements CourseService {


    @Override
    public void save(CourseEntity courseEntity) {

        Session session = getSession();
        session.save(courseEntity);
        closeSession(session);

    }



    @Override
    public CourseEntity get(Integer id) {
        Session session = getSession();
        CourseEntity courseEntity = session.get(CourseEntity.class, id);
        closeSession(session);
        return courseEntity;
    }

    @Override
    public void delete(Integer id) {
        Session session = getSession();
        CourseEntity courseEntity = session.get(CourseEntity.class, id);
        session.delete(courseEntity);
        closeSession(session);
        session.close();


    }
}
