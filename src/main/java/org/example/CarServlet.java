package org.example;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/garage")
public class CarServlet extends HttpServlet {

    private CarService carService = new CacheCarService( ServiceProvider.getInstance().getCarService());

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
            List<Car> cars = carService.getAll();
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/garage.jsp").forward(req, resp);

        } else {
            int idInt = Integer.valueOf(id);
            Car car = carService.getById(idInt);
            req.setAttribute("car", car);
            req.getRequestDispatcher("/garage.jsp").forward(req, resp);


        }


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        if (StringUtils.isNoneBlank(id, name, color)) {
            resp.setStatus(201);
            carService.saveCar(new Car(Integer.valueOf(id), name, color));
        } else {
            resp.setStatus(400);
        }
        resp.sendRedirect("garage");

    }


}
