package org.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SessionService {

    @Autowired
    private SessionFactory sessionFactory;


    public Session getSession() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {

        Transaction transaction = session.getTransaction();
        transaction.commit();
        session.close();
    }

}
