package org.example;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/garage")
public class CarServlet extends HttpServlet {
    private Garage garage = new Garage();
    private LocalTime timeLastRequest;



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.addCookie(new Cookie("lastReqTime",String.valueOf(timeLastRequest)));
        timeLastRequest =LocalTime.now();
        req.getSession();
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream out =resp.getOutputStream();
        if(req.getParameter("id")==null){
                      out.println(garage.toString());

        } else{
            int id = Integer.valueOf(req.getParameter("id"));
            Car car = garage.getCar(id);
            out.println(car.toString());

        }


    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{

       int id = Integer.valueOf( req.getParameter("id"));
       String name =req.getParameter("name");

       resp.setStatus(201);

       garage.setCar(new Car(id,name));



    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        timeLastRequest =LocalTime.now();
        int id =Integer.valueOf( req.getParameter("id"));
        garage.getCars().remove(id);
        resp.sendRedirect("car.html");

    }
    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        timeLastRequest =LocalTime.now();
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        garage.getCars().replace(id,new Car(id,name));

    }



}
