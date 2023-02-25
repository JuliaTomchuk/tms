package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.domain.CourseEntity;
import org.example.service.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private SessionFactory sessionFactory;

    @Override
    public void save(CourseEntity courseEntity) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(courseEntity);
        transaction.commit();
        session.close();

    }

    @Override
    public CourseEntity get(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CourseEntity courseEntity = session.get(CourseEntity.class, id);
        transaction.commit();
        session.close();
        return courseEntity;
    }

    @Override
    public void delete(int id) {
        CourseEntity courseEntity = get(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(courseEntity);
        transaction.commit();
        session.close();


    }
}
