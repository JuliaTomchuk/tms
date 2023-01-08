package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] carId = req.getParameterValues("carId");
        if (carId != null && CarServlet.garage.getCars().containsKey(Integer.valueOf(carId[0]))) {
            CarServlet.garage.deleteCar(Integer.valueOf(carId[0]));

        }
        String id = req.getParameter("idDel");
        if (id != null && CarServlet.garage.getCars().containsKey(Integer.valueOf(id))) {
            CarServlet.garage.deleteCar(Integer.valueOf(id));
        }

        resp.sendRedirect("garage");
    }
}
