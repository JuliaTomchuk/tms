package org.example;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private CarService carService = new CacheCarService(ServiceProvider.getInstance().getCarService());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUp = req.getParameter("idUp");
        String nameUp = req.getParameter("nameUp");
        String colorUp = req.getParameter("colorUp");

        if (StringUtils.isNoneBlank(idUp, nameUp, colorUp)) {
            carService.updateCar(new Car(Integer.valueOf(idUp), nameUp, colorUp));
        }
        resp.sendRedirect("garage");
    }
}
