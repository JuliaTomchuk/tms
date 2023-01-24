package org.example;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private CarService carService = new CacheCarService(ServiceProvider.getInstance().getCarService());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        if (StringUtils.isNotBlank(carId)) {
            carService.delete(Integer.valueOf(carId));

        }
        resp.sendRedirect("garage");
    }
}
