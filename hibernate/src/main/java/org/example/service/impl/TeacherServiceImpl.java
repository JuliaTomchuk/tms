package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.domain.TeacherEntity;
import org.example.service.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    SessionFactory sessionFactory;

    @Override
    public void save(TeacherEntity teacher) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();
        session.close();
    }

    @Override
    public TeacherEntity get(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TeacherEntity teacher = session.get(TeacherEntity.class, id);
        transaction.commit();
        session.close();
        return teacher;
    }

    @Override
    public void delete(int id) {
        TeacherEntity teacher = get(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(teacher);
        transaction.commit();
        session.close();


    }
}
