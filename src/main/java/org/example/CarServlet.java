package org.example;

import org.apache.commons.lang3.StringUtils;

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
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/garage")
public class CarServlet extends HttpServlet {
    private Garage garage = Garage.getInstance();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long timeLastRequest = System.currentTimeMillis();
        resp.addCookie(new Cookie("lastReqTime", String.valueOf(timeLastRequest)));
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (StringUtils.isBlank(id)) {
            req.setAttribute("garage", garage.getCars());
            req.getRequestDispatcher("/garage.jsp").forward(req, resp);

        } else {
            int idInt = Integer.valueOf(id);
            Optional<Car> car = garage.getCar(idInt);
            Car resultCar = car.orElseThrow();
            Map<Integer, Car> cars = new ConcurrentHashMap<>();
            cars.put(resultCar.getId(), resultCar);
            req.setAttribute("garage", cars);
            req.getRequestDispatcher("/garage.jsp").forward(req, resp);


        }


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        if (!(StringUtils.isAnyBlank(id, name, color))) {
            resp.setStatus(201);
            garage.addCar(new Car(Integer.valueOf(id), name, color));
        } else {
            resp.setStatus(400);
        }
        resp.sendRedirect("garage");

    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idDel");
        if (id != null && garage.getCars().containsKey(Integer.valueOf(id))) {
            garage.deleteCar(Integer.valueOf(id));

        } else {
            resp.setStatus(400);
        }

    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String color = req.getParameter("color");

        boolean containsKey = garage.getCars().containsKey(Integer.valueOf(id));

        if (containsKey && !(StringUtils.isAnyBlank(id, name, color))) {
            garage.getCars().replace(Integer.valueOf(id), new Car(Integer.valueOf(id), name, color));
        } else {
            resp.setStatus(400);
        }

    }


}
