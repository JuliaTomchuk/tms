package org.example;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LogListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String id = se.getSession().getId();

        System.out.println("-------------------------"+"Session has been created"+ id +"-----------------------------------------");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}

