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
import java.util.*;

@WebServlet("/garage")
public class CarServlet extends HttpServlet {

    private CarService carService = new CarServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long timeLastRequest = System.currentTimeMillis();
        resp.addCookie(new Cookie("lastReqTime", String.valueOf(timeLastRequest)));
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("id") == null || req.getParameter("id").isBlank()) {
            List<Car> cars = carService.getAll();
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/garage.jsp").forward(req, resp);

        } else {
            int id = Integer.valueOf(req.getParameter("id"));
            List<Car> cars = carService.getById(id);
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/garage.jsp").forward(req, resp);


        }


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        if (id != null && name != null) {
            resp.setStatus(201);
            carService.saveCar(new Car(Integer.valueOf(id), name, color));
        } else {
            resp.setStatus(400);
        }
        resp.sendRedirect("garage");

    }


}
