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
import java.util.Optional;

@WebServlet("/garage")
public class CarServlet extends HttpServlet {
    private Garage garage = new Garage();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long timeLastRequest = System.currentTimeMillis();
        resp.addCookie(new Cookie("lastReqTime", String.valueOf(timeLastRequest)));
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        if (req.getParameter("id") == null) {
            out.println(garage.toString());

        } else {
            int id = Integer.valueOf(req.getParameter("id"));
            Optional<Car> car = garage.getCar(id);
            out.println(car.get().toString());

        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        if (id != null && name != null) {
            resp.setStatus(201);
            garage.addCar(new Car(Integer.valueOf(id), name));
        } else {
            resp.setStatus(400);
        }


    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && garage.getCars().containsKey(Integer.valueOf(id))) {
            garage.deleteCar(Integer.valueOf(id));
            resp.sendRedirect("car.html");
        } else {
            resp.setStatus(400);
        }

    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        boolean isIdNull = (id == null);
        boolean isNameNull = (name == null);
        boolean containsKey = garage.getCars().containsKey(Integer.valueOf(id));

        if ((!isIdNull) && (!isNameNull) && containsKey) {
            garage.getCars().replace(Integer.valueOf(id), new Car(Integer.valueOf(id), name));
        } else {
            resp.setStatus(400);
        }

    }


}
