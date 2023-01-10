package org.example;

import com.sun.jdi.IntegerValue;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUp = req.getParameter("idUp");
        String nameUp = req.getParameter("nameUp");
        String colorUp = req.getParameter("colorUp");

        if (!(StringUtils.isAnyBlank(idUp, nameUp, colorUp)) && containsKey(Integer.valueOf(idUp))) {
            Garage.getInstance().getCars().replace(Integer.valueOf(idUp), new Car(Integer.valueOf(idUp), nameUp, colorUp));
        }
        resp.sendRedirect("garage");
    }

    private boolean containsKey(int id) {
        return Garage.getInstance().getCars().containsKey(id);
    }
}
